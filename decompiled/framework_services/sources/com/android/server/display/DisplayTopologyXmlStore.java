package com.android.server.display;

import android.hardware.display.DisplayTopology;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.AtomicFilePrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.display.topology.Children;
import com.android.server.display.topology.Display;
import com.android.server.display.topology.DisplayTopologyState;
import com.android.server.display.topology.Position;
import com.android.server.display.topology.Topology;
import com.android.server.display.topology.XmlParser;
import com.android.server.display.topology.XmlWriter;
import com.android.server.display.utils.DebugUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class DisplayTopologyXmlStore implements DisplayTopologyStore {
    private static final boolean DEBUG = false;
    private static final String DISPLAY_CONFIG_DIR = "displayconfig";
    private static final String ETC_DIR = "etc";
    private static final int MAX_NUMBER_OF_TOPOLOGIES = 100;
    private static final int MIN_REORDER_WHICH_TRIGGERS_PERSISTENCE = 10;
    private static final int PERSISTENT_TOPOLOGY_VERSION = 1;
    private static final String TAG = "DisplayManager.DisplayTopologyXmlStore";
    private final List<Topology> mImmutableTopologies;
    private final Injector mInjector;
    private final Map<String, Topology> mTopologies;
    private int mUserId;

    /* JADX INFO: renamed from: com.android.server.display.DisplayTopologyXmlStore$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$display$topology$Position = null;

        static {
            $SwitchMap$com$android$server$display$topology$Position = new int[Position.values().length];
            $SwitchMap$com$android$server$display$topology$Position[Position.left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L22:
            $SwitchMap$com$android$server$display$topology$Position[Position.top.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$com$android$server$display$topology$Position[Position.right.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            $SwitchMap$com$android$server$display$topology$Position[Position.bottom.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    static abstract class Injector {
        public abstract SparseArray<String> getDisplayIdToUniqueIdMapping();

        public abstract Map<String, Integer> getUniqueIdToDisplayIdMapping();

        Injector() {
        }

        public InputStream readVendorTopologies() throws FileNotFoundException {
            return getFileInputStream(DisplayTopologyXmlStore.m3800$$Nest$smgetVendorTopologyFile());
        }

        public InputStream readProductTopologies() throws FileNotFoundException {
            return getFileInputStream(DisplayTopologyXmlStore.m3799$$Nest$smgetProductTopologyFile());
        }

        InputStream readUserTopologies(int userId) throws FileNotFoundException {
            return getFileInputStream(DisplayTopologyXmlStore.getUserTopologyFile(userId));
        }

        AtomicFilePrintWriter getTopologyFilePrintWriter(int userId) throws IOException {
            AtomicFile atomicFile = new AtomicFile(DisplayTopologyXmlStore.getUserTopologyFile(userId), "topology-state");
            return new AtomicFilePrintWriter(atomicFile, StandardCharsets.UTF_8);
        }

        private FileInputStream getFileInputStream(File file) throws FileNotFoundException {
            if (DisplayTopologyXmlStore.m3798$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.d(DisplayTopologyXmlStore.TAG, "File: " + file + " exists=" + file.exists());
        L6:
            if (file.exists() == true) goto L9;
            return null;
        L9:
            return new FileInputStream(file);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3798$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetProductTopologyFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m3799$$Nest$smgetProductTopologyFile() {
        return getProductTopologyFile();
    }

    /* JADX INFO: renamed from: -$$Nest$smgetVendorTopologyFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m3800$$Nest$smgetVendorTopologyFile() {
        return getVendorTopologyFile();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    static File getUserTopologyFile(int userId) {
        return new File(Environment.getDataSystemCeDirectory(userId), "display_topology.xml");
    }

    private static File getVendorTopologyFile() {
        return Environment.buildPath(Environment.getVendorDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, "display_topology.xml"});
    }

    private static File getProductTopologyFile() {
        return Environment.buildPath(Environment.getProductDirectory(), new String[]{ETC_DIR, DISPLAY_CONFIG_DIR, "display_topology.xml"});
    }

    private static List<Topology> readTopologiesFromInputStream(InputStream iStream) throws DatatypeConfigurationException, XmlPullParserException, IOException {
        if (iStream == null) goto L5;
        DisplayTopologyState topologyState = XmlParser.read(iStream);
        if (topologyState.getVersion() <= 1) goto L14;
        Slog.e(TAG, "Topology version=" + topologyState.getVersion() + " is not supported by DisplayTopologyXmlStore version=1");
        return List.of();
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "readTopologiesFromInputStream: done");
    L16:
        List<Topology> topologyList = topologyState.getTopology();
        topologyList.sort(Comparator.comparingInt(new DisplayTopologyXmlStore$$ExternalSyntheticLambda0()));
        return topologyList;
    L5:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "iStream is null");
    L8:
        return List.of();
    }

    private static int getOrderOrDefault(Topology topology, int defaultOrder) {
        if (topology == null) goto L5;
        return topology.getOrder();
    L5:
        return defaultOrder;
    }

    DisplayTopologyXmlStore(Injector injector) {
        this.mUserId = -1;
        this.mImmutableTopologies = new ArrayList();
        this.mTopologies = new HashMap();
        this.mInjector = injector;
        reloadImmutableTopologies();
    }

    @Override // com.android.server.display.DisplayTopologyStore
    public boolean saveTopology(DisplayTopology topology) {
        String topologyId = getTopologyId(topology);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "saveTopology userId=" + this.mUserId + ", topologyId=" + topologyId);
    L6:
        if (topologyId != null) goto L9;
        Slog.w(TAG, "saveTopology cancelled: topology id is null for " + topology);
        return false;
    L9:
        Topology topologyToPersist = convertTopologyForPersistence(topology, topologyId);
        if (topologyToPersist != null) goto L14;
        Slog.w(TAG, "saveTopology cancelled: can't convert topology " + topology);
        return false;
    L14:
        if (prependTopology(topologyToPersist) == true) goto L17;
        Slog.w(TAG, "saveTopology cancelled: can't prependTopology");
        return false;
    L17:
        saveTopologiesToFile();
        return true;
    }

    @Override // com.android.server.display.DisplayTopologyStore
    public DisplayTopology restoreTopology(DisplayTopology topology) {
        String topologyId = getTopologyId(topology);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "restoreTopology userId=" + this.mUserId + ", topologyId=" + topologyId);
    L6:
        if (topologyId != null) goto L9;
        Slog.w(TAG, "restoreTopology cancelled: topology id is null for " + topology);
        return null;
    L9:
        Topology restoredTopology = this.mTopologies.get(topologyId);
        if (restoredTopology != null) goto L16;
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "restoreTopology userId=" + this.mUserId + ", topologyId=" + topologyId + " is not found");
    L14:
        return null;
    L16:
        if (restoredTopology.getOrder() < 10) goto L19;
        moveTopologyToHead(restoredTopology);
        saveTopologiesToFile();
    L19:
        return convertPersistentTopologyToDisplayTopology(topology, restoredTopology.getDisplay(), this.mInjector.getUniqueIdToDisplayIdMapping());
    }

    @Override // com.android.server.display.DisplayTopologyStore
    public void reloadTopologies(int userId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "reloadTopologies mUserId=" + this.mUserId + "->userId=" + userId);
    L6:
        if (this.mUserId == userId) goto L8;
        this.mUserId = userId;
        resetTopologies();
    L8:
        reloadTopologies();
    }

    private void resetTopologies() {
        this.mTopologies.clear();
        appendTopologies(this.mImmutableTopologies);
    }

    private void moveTopologyToHead(Topology topology) {
        if (topology.getOrder() != 0) goto L5;
        return;
    L5:
        Iterator<Topology> r0 = this.mTopologies.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Topology t = r0.next();
        if (t.getOrder() >= topology.getOrder()) goto L7;
        t.setOrder(t.getOrder() + 1);
        goto L7
    L12:
        topology.setOrder(0);
    }

    private void reloadImmutableTopologies() {
        this.mImmutableTopologies.clear();
        InputStream iStream = this.mInjector.readProductTopologies();     // Catch: Throwable -> L8
        this.mImmutableTopologies.addAll(readTopologiesFromInputStream(iStream));     // Catch: Throwable -> L11
        if (iStream == null) goto L45;
        iStream.close();     // Catch: Throwable -> L8 Throwable -> L8 Throwable -> L8
    L45:
        InputStream iStream2 = this.mInjector.readVendorTopologies();     // Catch: Throwable -> L25
        this.mImmutableTopologies.addAll(readTopologiesFromInputStream(iStream2));     // Catch: Throwable -> L28
        if (iStream2 == null) goto L37;
        iStream2.close();     // Catch: Throwable -> L25 Throwable -> L25 Throwable -> L25
    L37:
        Iterator<Topology> r0 = this.mImmutableTopologies.iterator();
    L39:
        if (r0.hasNext() == false) goto L41;
        Topology topology = r0.next();
        topology.setImmutable(true);
        goto L39
    L41:
        return;
    L28:
        th = move-exception;
        if (iStream2 != null) goto L43;
    L35:
        throw th;     // Catch: Throwable -> L25 Throwable -> L25 Throwable -> L25
    L43:
        iStream2.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 Throwable -> L25 Throwable -> L25
    L25:
        e = move-exception;
        Slog.e(TAG, "reloadImmutableTopologies for vendor topologies failed", e);
    L11:
        th = move-exception;
        if (iStream != null) goto L46;
    L18:
        throw th;     // Catch: Throwable -> L8 Throwable -> L8 Throwable -> L8
    L46:
        iStream.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 Throwable -> L8 Throwable -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "reloadImmutableTopologies for product topologies failed", e);
        goto L45
    }

    private void reloadTopologies() {
        if (this.mUserId >= 0) goto L28;
        Slog.e(TAG, "Can't reload topologies for userId=" + this.mUserId);
        return;
    L28:
        InputStream iStream = this.mInjector.readUserTopologies(this.mUserId);     // Catch: Throwable -> L11
        appendTopologies(readTopologiesFromInputStream(iStream));     // Catch: Throwable -> L14
        if (iStream == null) goto L29;
        iStream.close();     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
        return;
    L29:
        return;
    L14:
        th = move-exception;
        if (iStream != null) goto L26;
    L21:
        throw th;     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
    L26:
        iStream.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L11 Throwable -> L11 Throwable -> L11
    L11:
        e = move-exception;
        Slog.e(TAG, "reloadTopologies failed", e);
    }

    private void appendTopologies(List<Topology> topologyList) {
        Iterator<Topology> r0 = topologyList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Topology topology = r0.next();
        appendTopology(topology);
        goto L4
    }

    private void appendTopology(Topology topology) {
        Topology restoredTopology = this.mTopologies.get(topology.getId());
        if (restoredTopology != null) goto L5;
    L8:
        if (restoredTopology == null) goto L10;
    L15:
        topology.setOrder(getOrderOrDefault(restoredTopology, this.mTopologies.size()));
        this.mTopologies.put(topology.getId(), topology);
        return;
    L10:
        if (this.mTopologies.size() < 100) goto L15;
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "appendTopology: MAX_NUMBER_OF_TOPOLOGIES is reached, can't append topology" + topology.getId());
        return;
    L17:
        return;
    L5:
        if (restoredTopology.getImmutable() == false) goto L8;
        Slog.w(TAG, "addTopology: can't override immutable topology " + topology.getId());
    }

    private boolean prependTopology(Topology topology) {
        Topology restoredTopology = this.mTopologies.get(topology.getId());
        if (restoredTopology != null) goto L5;
    L8:
        if (restoredTopology == null) goto L10;
    L18:
        topology.setOrder(Integer.MAX_VALUE);
        moveTopologyToHead(topology);
        this.mTopologies.put(topology.getId(), topology);
        return true;
    L10:
        if (this.mTopologies.size() < 100) goto L18;
        Topology topologyToRemove = findMaxOrderMutableTopology();
        if (topologyToRemove != null) goto L15;
        Slog.w(TAG, "prependTopology: can't find a topology to remove to free up space");
        return false;
    L15:
        this.mTopologies.remove(topologyToRemove.getId());
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "prependTopology: remove topology " + topologyToRemove.getId());
        goto L18
    L5:
        if (restoredTopology.getImmutable() == false) goto L8;
        Slog.w(TAG, "prependTopology: can't override immutable topology " + topology.getId());
        return false;
    }

    private Topology findMaxOrderMutableTopology() {
        Topology res = null;
        Iterator<Topology> r1 = this.mTopologies.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Topology topology = r1.next();
        if (topology.getImmutable() == true) goto L4;
        if (res == null) goto L11;
        if (res.getOrder() >= topology.getOrder()) goto L4;
    L11:
        res = topology;
        goto L4
    L13:
        return res;
    }

    private void saveTopologiesToFile() {
        if (this.mUserId >= 0) goto L7;
        Slog.e(TAG, "Can't save topologies for userId=" + this.mUserId);
        return;
    L7:
        if (this.mTopologies.isEmpty() == true) goto L9;
        DisplayTopologyState topologyState = new DisplayTopologyState();
        topologyState.setVersion(1);
        Iterator<Topology> r2 = this.mTopologies.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L43;
        Topology topology = r2.next();
        if (topology.getImmutable() == true) goto L14;
        topologyState.getTopology().add(topology);
        goto L14
    L43:
        AtomicFilePrintWriter pw = this.mInjector.getTopologyFilePrintWriter(this.mUserId);     // Catch: IOException -> L28
        XmlWriter.write(new XmlWriter(pw), topologyState);     // Catch: Throwable -> L24
        pw.markSuccess();     // Catch: Throwable -> L24
        if (DEBUG == false) goto L26;
        Slog.d(TAG, "saveTopologiesToFile " + pw);     // Catch: Throwable -> L24
    L26:
        pw.close();     // Catch: IOException -> L28
        return;
    L24:
        th = move-exception;
        if (pw != null) goto L39;
    L36:
        throw th;     // Catch: IOException -> L28
    L39:
        pw.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Slog.e(TAG, "saveTopologiesToFile failed", e);
        return;
    L9:
        if (DEBUG == false) goto L48;
        Slog.d(TAG, "No topologies to save for userId=" + this.mUserId);
        return;
    }

    private DisplayTopology convertPersistentTopologyToDisplayTopology(DisplayTopology currentDisplayTopology, Display persistentDisplayTopology, Map<String, Integer> uniqueIdToDisplayIdMapping) {
        DisplayTopology.TreeNode rootNode = convertPersistentDisplayToTreeNode(persistentDisplayTopology, currentDisplayTopology, uniqueIdToDisplayIdMapping);
        int primaryDisplayId = findPrimaryDisplayId(persistentDisplayTopology, uniqueIdToDisplayIdMapping);
        if (primaryDisplayId != (-1)) goto L6;
        Slog.e(TAG, "Primary display id is not found in persistent topology");
        primaryDisplayId = 0;
    L6:
        return new DisplayTopology(rootNode, primaryDisplayId);
    }

    private DisplayTopology.TreeNode convertPersistentDisplayToTreeNode(Display persistentDisplay, DisplayTopology currentDisplayTopology, Map<String, Integer> uniqueIdToDisplayIdMapping) {
        Integer displayId = uniqueIdToDisplayIdMapping.get(persistentDisplay.getId());
        if (displayId == null) goto L15;
        DisplayTopology.TreeNode displayNode = DisplayTopology.findDisplay(displayId.intValue(), currentDisplayTopology.getRoot());
        if (displayNode == null) goto L13;
        List<DisplayTopology.TreeNode> children = new ArrayList();
        Iterator<Display> r2 = persistentDisplay.getChildren().getDisplay().iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        Display child = r2.next();
        children.add(convertPersistentDisplayToTreeNode(child, currentDisplayTopology, uniqueIdToDisplayIdMapping));
        goto L8
    L11:
        return new DisplayTopology.TreeNode(displayId.intValue(), displayNode.getWidth(), displayNode.getHeight(), toDisplayTopologyPosition(persistentDisplay.getPosition()), persistentDisplay.getOffset(), children);
    L13:
        throw new IllegalStateException("Can't find displayId=" + displayId + " in current topology");
    L15:
        throw new IllegalStateException("Can't map uniqueId=" + persistentDisplay.getId() + " to displayId");
    }

    private int findPrimaryDisplayId(Display persistentDisplay, Map<String, Integer> uniqueIdToDisplayIdMapping) {
        if (persistentDisplay.getPrimary() == false) goto L10;
        Integer displayId = uniqueIdToDisplayIdMapping.get(persistentDisplay.getId());
        if (displayId == null) goto L9;
        return displayId.intValue();
    L9:
        throw new IllegalStateException("Can't map uniqueId=" + persistentDisplay.getId() + " to displayId");
    L10:
        Iterator<Display> r0 = persistentDisplay.getChildren().getDisplay().iterator();
    L12:
        if (r0.hasNext() == false) goto L17;
        Display child = r0.next();
        int displayId2 = findPrimaryDisplayId(child, uniqueIdToDisplayIdMapping);
        if (displayId2 == (-1)) goto L12;
        return displayId2;
    L17:
        return -1;
    }

    private Topology convertTopologyForPersistence(DisplayTopology topology, String topologyId) {
        Display rootNode = convertTreeNodeForPersistence(topology.getRoot(), topology.getPrimaryDisplayId(), this.mInjector.getDisplayIdToUniqueIdMapping());
        if (rootNode != null) goto L6;
        return null;
    L6:
        Topology persistentTopology = new Topology();
        persistentTopology.setDisplay(rootNode);
        persistentTopology.setId(topologyId);
        return persistentTopology;
    }

    private Display convertTreeNodeForPersistence(DisplayTopology.TreeNode node, int primaryDisplayId, SparseArray<String> idsToUniqueIds) {
        if (node != null) goto L6;
        Slog.e(TAG, "Can't convertTreeNodeForPersistence, node == null");
        return null;
    L6:
        String uniqueId = idsToUniqueIds.get(node.getDisplayId());
        if (uniqueId != null) goto L10;
        Slog.e(TAG, "Can't convertTreeNodeForPersistence, uniqueId is not found for " + node.getDisplayId());
        return null;
    L10:
        Children children = new Children();
        Iterator r3 = node.getChildren().iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        DisplayTopology.TreeNode child = (DisplayTopology.TreeNode) r3.next();
        Display display = convertTreeNodeForPersistence(child, primaryDisplayId, idsToUniqueIds);
        if (display == null) goto L15;
        children.getDisplay().add(display);
        goto L12
    L15:
        return null;
    L17:
        Display root = new Display();
        root.setPosition(toPersistentPosition(node.getPosition()));
        root.setId(uniqueId);
        root.setOffset(node.getOffset());
        if (node.getDisplayId() != primaryDisplayId) goto L20;
        boolean r4 = true;
    L21:
        root.setPrimary(r4);
        root.setChildren(children);
        return root;
    L20:
        r4 = false;
        goto L21
    }

    private Position toPersistentPosition(int pos) {
        switch(pos) {
            case 0: goto L9;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown position=" + pos);
    L10:
        return Position.bottom;
    L11:
        return Position.right;
    L12:
        return Position.top;
    L9:
        return Position.left;
    }

    private int toDisplayTopologyPosition(Position pos) {
        switch(AnonymousClass1.$SwitchMap$com$android$server$display$topology$Position[pos.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return 3;
    L7:
        return 2;
    L8:
        return 1;
    L9:
        return 0;
    L5:
        throw new RuntimeException(null, null);
    }

    private List<String> getUniqueIds(DisplayTopology.TreeNode node, SparseArray<String> mapping, List<String> uniqueIds) {
        if (node != null) goto L4;
        return uniqueIds;
    L4:
        uniqueIds.add(mapping.get(node.getDisplayId()));
        Iterator r0 = node.getChildren().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        DisplayTopology.TreeNode child = (DisplayTopology.TreeNode) r0.next();
        getUniqueIds(child, mapping, uniqueIds);
        goto L6
    L8:
        return uniqueIds;
    }

    private String getTopologyId(DisplayTopology topology) {
        SparseArray<String> mapping = this.mInjector.getDisplayIdToUniqueIdMapping();
        return getTopologyId(getUniqueIds(topology.getRoot(), mapping, new ArrayList()));
    }

    private String getTopologyId(List<String> uniqueIds) {
        if (uniqueIds.isEmpty() == false) goto L5;
    L9:
        return null;
    L5:
        if (uniqueIds.contains(null) == true) goto L9;
        Collections.sort(uniqueIds);
        return String.join("|", uniqueIds);
    }
}
