package com.android.server.devicepolicy;

import android.app.admin.DevicePolicyDrawableResource;
import android.app.admin.DevicePolicyStringResource;
import android.app.admin.ParcelableResource;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class DeviceManagementResourcesProvider {
    private static final String ATTR_DRAWABLE_ID = "drawable-id";
    private static final String ATTR_DRAWABLE_SOURCE = "drawable-source";
    private static final String ATTR_DRAWABLE_STYLE = "drawable-style";
    private static final String ATTR_SOURCE_ID = "source-id";
    private static final String TAG = "DevicePolicyManagerService";
    private static final String TAG_DRAWABLE_SOURCE_ENTRY = "drawable-source-entry";
    private static final String TAG_DRAWABLE_STYLE_ENTRY = "drawable-style-entry";
    private static final String TAG_ROOT = "root";
    private static final String TAG_STRING_ENTRY = "string-entry";
    private static final String UPDATED_RESOURCES_XML = "updated_resources.xml";
    private final Injector mInjector;
    private final Object mLock;
    private final Map<String, Map<String, Map<String, ParcelableResource>>> mUpdatedDrawablesForSource;
    private final Map<String, Map<String, ParcelableResource>> mUpdatedDrawablesForStyle;
    private final Map<String, ParcelableResource> mUpdatedStrings;

    public static class Injector {
        public Injector() {
        }

        File environmentGetDataSystemDirectory() {
            return Environment.getDataSystemDirectory();
        }
    }

    private class ResourcesReaderWriter {
        private final File mFile;
        final /* synthetic */ DeviceManagementResourcesProvider this$0;

        /* synthetic */ ResourcesReaderWriter(DeviceManagementResourcesProvider r1, DeviceManagementResourcesProviderIA r2) {
            this(r1);
        }

        private ResourcesReaderWriter(DeviceManagementResourcesProvider r1) {
            this.this$0 = r1;
            this.mFile = DeviceManagementResourcesProvider.m3330$$Nest$mgetResourcesFile(r1);
        }

        void writeToFileLocked() {
            Log.d(DeviceManagementResourcesProvider.TAG, "Writing to " + this.mFile);
            AtomicFile f = new AtomicFile(this.mFile);
            FileOutputStream outputStream = null;
            outputStream = f.startWrite();     // Catch: IOException -> L5
            TypedXmlSerializer out = Xml.resolveSerializer(outputStream);     // Catch: IOException -> L5
            out.startDocument(null, true);     // Catch: IOException -> L5
            out.startTag(null, DeviceManagementResourcesProvider.TAG_ROOT);     // Catch: IOException -> L5
            writeInner(out);     // Catch: IOException -> L5
            out.endTag(null, DeviceManagementResourcesProvider.TAG_ROOT);     // Catch: IOException -> L5
            out.endDocument();     // Catch: IOException -> L5
            out.flush();     // Catch: IOException -> L5
            f.finishWrite(outputStream);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(DeviceManagementResourcesProvider.TAG, "Exception when writing", e);
            if (outputStream == null) goto L10;
            f.failWrite(outputStream);
        }

        void readFromFileLocked() {
            if (this.mFile.exists() == true) goto L6;
            Log.d(DeviceManagementResourcesProvider.TAG, "" + this.mFile + " doesn't exist");
            return;
        L6:
            Log.d(DeviceManagementResourcesProvider.TAG, "Reading from " + this.mFile);
            AtomicFile f = new AtomicFile(this.mFile);
            InputStream input = null;
            input = f.openRead();     // Catch: Throwable -> L21 Throwable -> L23
            TypedXmlPullParser parser = Xml.resolvePullParser(input);     // Catch: Throwable -> L21 Throwable -> L23
            int depth = 0;
        L8:
            int type = parser.next();     // Catch: Throwable -> L21 Throwable -> L23
            if (type == 1) goto L31;
            switch(type) {
                case 2: goto L14;
                case 3: goto L12;
                default: goto L8;
            };     // Catch: Throwable -> L21 Throwable -> L23
        L14:
            depth = depth + 1;     // Catch: Throwable -> L21 Throwable -> L23
            String tag = parser.getName();     // Catch: Throwable -> L21 Throwable -> L23
            if (depth == 1) goto L17;
            if (readInner(parser, depth, tag) == true) goto L8;
            IoUtils.closeQuietly(input);
            return;
        L17:
            if (DeviceManagementResourcesProvider.TAG_ROOT.equals(tag) == true) goto L8;
            Log.e(DeviceManagementResourcesProvider.TAG, "Invalid root tag: " + tag);     // Catch: Throwable -> L21 Throwable -> L23
            IoUtils.closeQuietly(input);
            return;
        L12:
            depth = depth - 1;     // Catch: Throwable -> L21 Throwable -> L23
        L31:
            IoUtils.closeQuietly(input);
            return;
        L23:
            e = move-exception;
            Log.e(DeviceManagementResourcesProvider.TAG, "Error parsing resources file", e);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            IoUtils.closeQuietly(input);
            throw th;
        }

        void writeInner(TypedXmlSerializer out) throws IOException {
            writeDrawablesForStylesInner(out);
            writeDrawablesForSourcesInner(out);
            writeStringsInner(out);
        }

        private void writeDrawablesForStylesInner(TypedXmlSerializer out) throws IOException {
            if (DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0) != null) goto L5;
            return;
        L5:
            if (DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0).isEmpty() == true) goto L17;
            Iterator r0 = DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0).entrySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L18;
            Map.Entry<String, Map<String, ParcelableResource>> drawableEntry = (Map.Entry) r0.next();
            Iterator<Map.Entry<String, ParcelableResource>> r2 = drawableEntry.getValue().entrySet().iterator();
        L11:
            if (r2.hasNext() == false) goto L8;
            Map.Entry<String, ParcelableResource> styleEntry = r2.next();
            out.startTag(null, DeviceManagementResourcesProvider.TAG_DRAWABLE_STYLE_ENTRY);
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_ID, drawableEntry.getKey());
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_STYLE, styleEntry.getKey());
            styleEntry.getValue().writeToXmlFile(out);
            out.endTag(null, DeviceManagementResourcesProvider.TAG_DRAWABLE_STYLE_ENTRY);
            goto L11
        L18:
            return;
        }

        private void writeDrawablesForSourcesInner(TypedXmlSerializer out) throws IOException {
            if (DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0) != null) goto L5;
            return;
        L5:
            if (DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).isEmpty() == true) goto L22;
            Iterator r0 = DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).entrySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L23;
            Map.Entry<String, Map<String, Map<String, ParcelableResource>>> drawableEntry = (Map.Entry) r0.next();
            Iterator<Map.Entry<String, Map<String, ParcelableResource>>> r2 = drawableEntry.getValue().entrySet().iterator();
        L11:
            if (r2.hasNext() == false) goto L8;
            Map.Entry<String, Map<String, ParcelableResource>> sourceEntry = r2.next();
            Iterator<Map.Entry<String, ParcelableResource>> r4 = sourceEntry.getValue().entrySet().iterator();
        L14:
            if (r4.hasNext() == false) goto L11;
            Map.Entry<String, ParcelableResource> styleEntry = r4.next();
            out.startTag(null, DeviceManagementResourcesProvider.TAG_DRAWABLE_SOURCE_ENTRY);
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_ID, drawableEntry.getKey());
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_SOURCE, sourceEntry.getKey());
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_STYLE, styleEntry.getKey());
            styleEntry.getValue().writeToXmlFile(out);
            out.endTag(null, DeviceManagementResourcesProvider.TAG_DRAWABLE_SOURCE_ENTRY);
            goto L14
        L23:
            return;
        }

        private void writeStringsInner(TypedXmlSerializer out) throws IOException {
            if (DeviceManagementResourcesProvider.m3329$$Nest$fgetmUpdatedStrings(this.this$0) != null) goto L5;
            return;
        L5:
            if (DeviceManagementResourcesProvider.m3329$$Nest$fgetmUpdatedStrings(this.this$0).isEmpty() == true) goto L12;
            Iterator r0 = DeviceManagementResourcesProvider.m3329$$Nest$fgetmUpdatedStrings(this.this$0).entrySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L13;
            Map.Entry<String, ParcelableResource> entry = (Map.Entry) r0.next();
            out.startTag(null, DeviceManagementResourcesProvider.TAG_STRING_ENTRY);
            out.attribute(null, DeviceManagementResourcesProvider.ATTR_SOURCE_ID, entry.getKey());
            entry.getValue().writeToXmlFile(out);
            out.endTag(null, DeviceManagementResourcesProvider.TAG_STRING_ENTRY);
            goto L8
        L13:
            return;
        }

        private boolean readInner(TypedXmlPullParser parser, int depth, String tag) throws XmlPullParserException, IOException {
            byte r1 = 2;
            if (depth <= 2) goto L6;
            return true;
        L6:
            switch(tag.hashCode()) {
                case -1021023306: goto L15;
                case 1224071439: goto L12;
                case 1406273191: goto L9;
                default: goto L17;
            };
        L17:
            r1 = -1;
        L19:
            switch(r1) {
                case 0: goto L30;
                case 1: goto L23;
                case 2: goto L22;
                default: goto L20;
            };
        L20:
            Log.e(DeviceManagementResourcesProvider.TAG, "Unexpected tag: " + tag);
            return false;
        L22:
            DeviceManagementResourcesProvider.m3329$$Nest$fgetmUpdatedStrings(this.this$0).put(parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_SOURCE_ID), ParcelableResource.createFromXml(parser));
        L34:
            return true;
        L23:
            String id = parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_ID);
            String source = parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_SOURCE);
            String style = parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_STYLE);
            ParcelableResource resource = ParcelableResource.createFromXml(parser);
            if (DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).containsKey(id) == true) goto L27;
            DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).put(id, new HashMap());
        L27:
            if (((Map) DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).get(id)).containsKey(source) == true) goto L29;
            ((Map) DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).get(id)).put(source, new HashMap());
        L29:
            ((Map) ((Map) DeviceManagementResourcesProvider.m3327$$Nest$fgetmUpdatedDrawablesForSource(this.this$0).get(id)).get(source)).put(style, resource);
            goto L34
        L30:
            String id2 = parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_ID);
            String style2 = parser.getAttributeValue(null, DeviceManagementResourcesProvider.ATTR_DRAWABLE_STYLE);
            ParcelableResource resource2 = ParcelableResource.createFromXml(parser);
            if (DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0).containsKey(id2) == true) goto L33;
            DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0).put(id2, new HashMap());
        L33:
            ((Map) DeviceManagementResourcesProvider.m3328$$Nest$fgetmUpdatedDrawablesForStyle(this.this$0).get(id2)).put(style2, resource2);
            goto L34
        L9:
            if (tag.equals(DeviceManagementResourcesProvider.TAG_DRAWABLE_STYLE_ENTRY) == false) goto L17;
            r1 = 0;
            goto L19
        L12:
            if (tag.equals(DeviceManagementResourcesProvider.TAG_DRAWABLE_SOURCE_ENTRY) == false) goto L17;
            r1 = 1;
            goto L19
        L15:
            if (tag.equals(DeviceManagementResourcesProvider.TAG_STRING_ENTRY) == false) goto L17;
            goto L17
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdatedDrawablesForSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3327$$Nest$fgetmUpdatedDrawablesForSource(DeviceManagementResourcesProvider r0) {
        return r0.mUpdatedDrawablesForSource;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdatedDrawablesForStyle, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3328$$Nest$fgetmUpdatedDrawablesForStyle(DeviceManagementResourcesProvider r0) {
        return r0.mUpdatedDrawablesForStyle;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdatedStrings, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3329$$Nest$fgetmUpdatedStrings(DeviceManagementResourcesProvider r0) {
        return r0.mUpdatedStrings;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetResourcesFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m3330$$Nest$mgetResourcesFile(DeviceManagementResourcesProvider r0) {
        return r0.getResourcesFile();
    }

    DeviceManagementResourcesProvider() {
        this(new Injector());
    }

    DeviceManagementResourcesProvider(Injector injector) {
        this.mUpdatedDrawablesForStyle = new HashMap();
        this.mUpdatedDrawablesForSource = new HashMap();
        this.mUpdatedStrings = new HashMap();
        this.mLock = new Object();
        injector.getClass();
        this.mInjector = injector;
    }

    boolean updateDrawables(List<DevicePolicyDrawableResource> drawables) {
        boolean updated = false;
        int i = 0;
    L4:
        if (i >= drawables.size()) goto L11;
        String drawableId = drawables.get(i).getDrawableId();
        String drawableStyle = drawables.get(i).getDrawableStyle();
        String drawableSource = drawables.get(i).getDrawableSource();
        ParcelableResource resource = drawables.get(i).getResource();
        drawableId.getClass();
        drawableStyle.getClass();
        drawableSource.getClass();
        resource.getClass();
        if ("UNDEFINED".equals(drawableSource) == false) goto L8;
        boolean r6 = updateDrawable(drawableId, drawableStyle, resource);
    L9:
        updated = updated | r6;
        i = i + 1;
        goto L4
    L8:
        r6 = updateDrawableForSource(drawableId, drawableSource, drawableStyle, resource);
        goto L9
    L11:
        if (updated == true) goto L14;
        return false;
    L14:
        Object r1 = this.mLock;
        monitor-enter(r1);
        write();     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    private boolean updateDrawable(String drawableId, String drawableStyle, ParcelableResource updatableResource) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatedDrawablesForStyle.containsKey(drawableId) == true) goto L9;
        this.mUpdatedDrawablesForStyle.put(drawableId, new HashMap());     // Catch: Throwable -> L7
    L9:
        ParcelableResource current = this.mUpdatedDrawablesForStyle.get(drawableId).get(drawableStyle);     // Catch: Throwable -> L7
        if (updatableResource.equals(current) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    L14:
        this.mUpdatedDrawablesForStyle.get(drawableId).put(drawableStyle, updatableResource);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return true;
    }

    private boolean updateDrawableForSource(String drawableId, String drawableSource, String drawableStyle, ParcelableResource updatableResource) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatedDrawablesForSource.containsKey(drawableId) == true) goto L9;
        this.mUpdatedDrawablesForSource.put(drawableId, new HashMap());     // Catch: Throwable -> L7
    L9:
        Map<String, Map<String, ParcelableResource>> drawablesForId = this.mUpdatedDrawablesForSource.get(drawableId);     // Catch: Throwable -> L7
        if (drawablesForId.containsKey(drawableSource) == true) goto L12;
        this.mUpdatedDrawablesForSource.get(drawableId).put(drawableSource, new HashMap());     // Catch: Throwable -> L7
    L12:
        ParcelableResource current = drawablesForId.get(drawableSource).get(drawableStyle);     // Catch: Throwable -> L7
        if (updatableResource.equals(current) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    L17:
        drawablesForId.get(drawableSource).put(drawableStyle, updatableResource);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return true;
    }

    boolean removeDrawables(List<String> drawableIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean removed = false;
        int i = 0;
    L25:
        boolean r4 = false;
        if (i >= drawableIds.size()) goto L17;
        String drawableId = drawableIds.get(i);     // Catch: Throwable -> L12
        if (this.mUpdatedDrawablesForStyle.remove(drawableId) == null) goto L10;
    L14:
        r4 = true;
    L15:
        removed = removed | r4;     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L25
    L10:
        if (this.mUpdatedDrawablesForSource.remove(drawableId) == null) goto L15;
    L17:
        if (removed == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L20:
        write();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    ParcelableResource getDrawable(String drawableId, String drawableStyle, String drawableSource) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ParcelableResource resource = getDrawableForSourceLocked(drawableId, drawableStyle, drawableSource);     // Catch: Throwable -> L8
        if (resource == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return resource;
    L11:
        if (this.mUpdatedDrawablesForStyle.containsKey(drawableId) == true) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L15:
        ParcelableResource r2 = this.mUpdatedDrawablesForStyle.get(drawableId).get(drawableStyle);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    ParcelableResource getDrawableForSourceLocked(String drawableId, String drawableStyle, String drawableSource) {
        if (this.mUpdatedDrawablesForSource.containsKey(drawableId) == true) goto L6;
        return null;
    L6:
        if (this.mUpdatedDrawablesForSource.get(drawableId).containsKey(drawableSource) == true) goto L9;
        return null;
    L9:
        return this.mUpdatedDrawablesForSource.get(drawableId).get(drawableSource).get(drawableStyle);
    }

    boolean updateStrings(List<DevicePolicyStringResource> strings) {
        boolean updated = false;
        int i = 0;
    L4:
        if (i >= strings.size()) goto L7;
        String stringId = strings.get(i).getStringId();
        ParcelableResource resource = strings.get(i).getResource();
        stringId.getClass();
        resource.getClass();
        updated = updated | updateString(stringId, resource);
        i = i + 1;
        goto L4
    L7:
        if (updated == true) goto L10;
        return false;
    L10:
        Object r1 = this.mLock;
        monitor-enter(r1);
        write();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean updateString(String stringId, ParcelableResource updatableResource) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ParcelableResource current = this.mUpdatedStrings.get(stringId);     // Catch: Throwable -> L9
        if (updatableResource.equals(current) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mUpdatedStrings.put(stringId, updatableResource);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean removeStrings(List<String> stringIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean removed = false;
        int i = 0;
    L22:
        boolean r4 = false;
        if (i >= stringIds.size()) goto L14;
        String stringId = stringIds.get(i);     // Catch: Throwable -> L11
        if (this.mUpdatedStrings.remove(stringId) == null) goto L10;
        r4 = true;
    L10:
        removed = removed | r4;     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L22
    L14:
        if (removed == true) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L17:
        write();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    ParcelableResource getString(String stringId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ParcelableResource r1 = this.mUpdatedStrings.get(stringId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void write() {
        Log.d(TAG, "Writing updated resources to file.");
        new ResourcesReaderWriter(this, null).writeToFileLocked();
    }

    void load() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        new ResourcesReaderWriter(this, null).readFromFileLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private File getResourcesFile() {
        return new File(this.mInjector.environmentGetDataSystemDirectory(), UPDATED_RESOURCES_XML);
    }
}
