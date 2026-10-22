package com.android.server.broadcastradio.hal2;

import android.hardware.broadcastradio.V2_0.AmFmBandRange;
import android.hardware.broadcastradio.V2_0.AmFmRegionConfig;
import android.hardware.broadcastradio.V2_0.DabTableEntry;
import android.hardware.broadcastradio.V2_0.Metadata;
import android.hardware.broadcastradio.V2_0.MetadataKey;
import android.hardware.broadcastradio.V2_0.ProgramFilter;
import android.hardware.broadcastradio.V2_0.ProgramIdentifier;
import android.hardware.broadcastradio.V2_0.ProgramInfo;
import android.hardware.broadcastradio.V2_0.Properties;
import android.hardware.broadcastradio.V2_0.Result;
import android.hardware.broadcastradio.V2_0.VendorKeyValue;
import android.hardware.radio.Announcement;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioManager;
import android.hardware.radio.RadioMetadata;
import android.os.ParcelableException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
final class Convert {
    private static final SparseArray<MetadataDef> METADATA_KEYS = null;
    private static final String TAG = "BcRadio2Srv.convert";

    private static class MetadataDef {
        private String key;
        private MetadataType type;

        /* JADX INFO: renamed from: -$$Nest$fgetkey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2830$$Nest$fgetkey(MetadataDef r0) {
            return r0.key;
        }

        /* JADX INFO: renamed from: -$$Nest$fgettype, reason: not valid java name */
        static /* bridge */ /* synthetic */ MetadataType m2831$$Nest$fgettype(MetadataDef r0) {
            return r0.type;
        }

        /* synthetic */ MetadataDef(MetadataType r1, String r2, ConvertIA r3) {
            this(r1, r2);
        }

        private MetadataDef(MetadataType type, String key) {
            this.type = type;
            this.key = key;
        }
    }

    private static final enum MetadataType extends Enum<MetadataType> {
        private static final /* synthetic */ MetadataType[] $VALUES = null;
        public static final MetadataType INT = null;
        public static final MetadataType STRING = null;

        private static /* synthetic */ MetadataType[] $values() {
            return new MetadataType[]{INT, STRING};
        }

        private MetadataType(String r1, int r2) {
            super(r1, r2);
        }

        public static MetadataType valueOf(String name) {
            return (MetadataType) Enum.valueOf(MetadataType.class, name);
        }

        public static MetadataType[] values() {
            return (MetadataType[]) $VALUES.clone();
        }

        static {
            INT = new MetadataType("INT", 0);
            STRING = new MetadataType("STRING", 1);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ String $r8$lambda$Jig2bRdUIGWrKL7RScdyXuYkMxc(DabTableEntry r0) {
        return lambda$dabConfigFromHal$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$RcHlNPbTeMTyJuiCUIWUIY-zQOA, reason: not valid java name */
    public static /* synthetic */ ProgramSelector.Identifier[] m2827$r8$lambda$RcHlNPbTeMTyJuiCUIWUIYzQOA(int r0) {
        return lambda$programSelectorFromHal$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dNJVjCBSZkHfa9_PN-zi69mWyeA, reason: not valid java name */
    public static /* synthetic */ ProgramSelector.Identifier m2828$r8$lambda$dNJVjCBSZkHfa9_PNzi69mWyeA(ProgramIdentifier r0) {
        return lambda$programInfoFromHal$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$rtg3B7nE0QZFTma38c-0o2WeNJ8, reason: not valid java name */
    public static /* synthetic */ void m2829$r8$lambda$rtg3B7nE0QZFTma38c0o2WeNJ8(ProgramFilter r0, ProgramSelector.Identifier r1) {
        lambda$programFilterToHal$4(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$zPclBuLUbNpUHy_xb1GFeN4tQ4E(DabTableEntry r0) {
        return lambda$dabConfigFromHal$1(r0);
    }

    private Convert() {
        throw new UnsupportedOperationException("Convert class is noninstantiable");
    }

    static void throwOnError(String action, int result) {
        String errorString = action + ": " + Result.toString(result);
        switch(result) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L13;
            default: goto L5;
        };
    L14:
        return;
    L5:
        throw new ParcelableException(new RuntimeException(action + ": unknown error (" + result + ")"));
    L7:
        throw new UnsupportedOperationException(errorString);
    L9:
        throw new IllegalStateException(errorString);
    L11:
        throw new IllegalArgumentException(errorString);
    L13:
        throw new ParcelableException(new RuntimeException(errorString));
    }

    static int halResultToTunerResult(int result) {
        switch(result) {
            case 0: goto L15;
            case 1: goto L3;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 7;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 1;
    L15:
        return 0;
    }

    static ArrayList<VendorKeyValue> vendorInfoToHal(Map<String, String> info) {
        if (info == null) goto L4;
        ArrayList<VendorKeyValue> list = new ArrayList();
        Iterator<Map.Entry<String, String>> r1 = info.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, String> entry = r1.next();
        VendorKeyValue elem = new VendorKeyValue();
        elem.key = entry.getKey();
        elem.value = entry.getValue();
        if (elem.key == null) goto L14;
        if (elem.value == null) goto L14;
        list.add(elem);
    L14:
        Slogf.w(TAG, "VendorKeyValue contains null pointers");
        goto L7
    L15:
        return list;
    L4:
        return new ArrayList();
    }

    static Map<String, String> vendorInfoFromHal(List<VendorKeyValue> info) {
        Map<String, String> vendorInfoMap = new ArrayMap();
        if (info != null) goto L5;
        return vendorInfoMap;
    L5:
        Iterator<VendorKeyValue> r1 = info.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        VendorKeyValue kvp = r1.next();
        if (kvp.key == null) goto L14;
        if (kvp.value == null) goto L14;
        vendorInfoMap.put(kvp.key, kvp.value);
    L14:
        Slogf.w(TAG, "VendorKeyValue contains null pointers");
        goto L7
    L15:
        return vendorInfoMap;
    }

    private static int identifierTypeToProgramType(int idType) {
        switch(idType) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L4;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L4;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L14;
            default: goto L4;
        };
    L10:
        return 7;
    L12:
        return 6;
    L14:
        return 5;
    L16:
        return 4;
    L18:
        return 2;
    L4:
        if (idType >= 1000) goto L6;
        return 0;
    L6:
        if (idType > 1999) goto L20;
        return idType;
    L20:
        return 0;
    }

    private static int[] identifierTypesToProgramTypes(int[] idTypes) {
        Set<Integer> pTypes = new ArraySet();
        int r1 = idTypes.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        int idType = idTypes[r2];
        int pType = identifierTypeToProgramType(idType);
        if (pType == 0) goto L13;
        pTypes.add(Integer.valueOf(pType));
        if (pType != 2) goto L11;
        pTypes.add(1);
    L11:
        if (pType != 4) goto L13;
        pTypes.add(3);
    L13:
        r2 = r2 + 1;
        goto L3
    L15:
        return pTypes.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
    }

    private static RadioManager.BandDescriptor[] amfmConfigToBands(AmFmRegionConfig config) {
        if (config == null) goto L5;
        int len = config.ranges.size();
        List<RadioManager.BandDescriptor> bands = new ArrayList(len);
        Iterator<AmFmBandRange> r14 = config.ranges.iterator();
    L8:
        if (r14.hasNext() == false) goto L18;
        AmFmBandRange range = r14.next();
        FrequencyBand bandType = Utils.getBand(range.lowerBound);
        if (bandType == FrequencyBand.UNKNOWN) goto L11;
        if (bandType == FrequencyBand.FM) goto L14;
        bands.add(new RadioManager.AmBandDescriptor(0, 0, range.lowerBound, range.upperBound, range.spacing, true));
        goto L8
    L14:
        bands.add(new RadioManager.FmBandDescriptor(0, 1, range.lowerBound, range.upperBound, range.spacing, true, true, true, true, true));
        goto L8
    L11:
        Slogf.e(TAG, "Unknown frequency band at " + range.lowerBound + "kHz");
        goto L8
    L18:
        return (RadioManager.BandDescriptor[]) bands.toArray(new RadioManager.BandDescriptor[bands.size()]);
    L5:
        return new RadioManager.BandDescriptor[0];
    }

    private static Map<String, Integer> dabConfigFromHal(List<DabTableEntry> config) {
        if (config != null) goto L6;
        return null;
    L6:
        return (Map) config.stream().collect(Collectors.toMap(new Convert$$ExternalSyntheticLambda8(), new Convert$$ExternalSyntheticLambda9()));
    }

    private static /* synthetic */ String lambda$dabConfigFromHal$0(DabTableEntry e) {
        return e.label;
    }

    private static /* synthetic */ Integer lambda$dabConfigFromHal$1(DabTableEntry e) {
        return Integer.valueOf(e.frequency);
    }

    static RadioManager.ModuleProperties propertiesFromHal(int id, String serviceName, Properties prop, AmFmRegionConfig amfmConfig, List<DabTableEntry> dabConfig) {
        serviceName.getClass();
        prop.getClass();
        int[] supportedIdentifierTypes = prop.supportedIdentifierTypes.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
        int[] supportedProgramTypes = identifierTypesToProgramTypes(supportedIdentifierTypes);
        return new RadioManager.ModuleProperties(id, serviceName, 0, prop.maker, prop.product, prop.version, prop.serial, 1, 1, false, false, amfmConfigToBands(amfmConfig), true, supportedProgramTypes, supportedIdentifierTypes, dabConfigFromHal(dabConfig), vendorInfoFromHal(prop.vendorInfo));
    }

    static void programIdentifierToHal(ProgramIdentifier hwId, ProgramSelector.Identifier id) {
        hwId.type = id.getType();
        hwId.value = id.getValue();
    }

    static ProgramIdentifier programIdentifierToHal(ProgramSelector.Identifier id) {
        ProgramIdentifier hwId = new ProgramIdentifier();
        programIdentifierToHal(hwId, id);
        return hwId;
    }

    static ProgramSelector.Identifier programIdentifierFromHal(ProgramIdentifier id) {
        if (id.type != 0) goto L7;
        return null;
    L7:
        return new ProgramSelector.Identifier(id.type, id.value);
    }

    static android.hardware.broadcastradio.V2_0.ProgramSelector programSelectorToHal(ProgramSelector sel) {
        android.hardware.broadcastradio.V2_0.ProgramSelector hwSel = new android.hardware.broadcastradio.V2_0.ProgramSelector();
        programIdentifierToHal(hwSel.primaryId, sel.getPrimaryId());
        Stream r1 = Arrays.stream(sel.getSecondaryIds()).map(new Convert$$ExternalSyntheticLambda3());
        final ArrayList<ProgramIdentifier> r2 = hwSel.secondaryIds;
        r2.getClass();
        r1.forEachOrdered(new Convert$$ExternalSyntheticLambda4(r2));
        return hwSel;
    }

    private static boolean isEmpty(android.hardware.broadcastradio.V2_0.ProgramSelector sel) {
        if (sel.primaryId.type == 0) goto L5;
    L9:
        return false;
    L5:
        if (sel.primaryId.value != 0) goto L9;
        if (sel.secondaryIds.isEmpty() == false) goto L9;
        return true;
    }

    static ProgramSelector programSelectorFromHal(android.hardware.broadcastradio.V2_0.ProgramSelector sel) {
        if (isEmpty(sel) == false) goto L5;
        return null;
    L5:
        ProgramSelector.Identifier[] secondaryIds = (ProgramSelector.Identifier[]) sel.secondaryIds.stream().map(new Convert$$ExternalSyntheticLambda0()).map(new Convert$$ExternalSyntheticLambda1()).toArray(new Convert$$ExternalSyntheticLambda2());
        int r3 = identifierTypeToProgramType(sel.primaryId.type);
        ProgramSelector.Identifier r4 = programIdentifierFromHal(sel.primaryId);
        r4.getClass();
        return new ProgramSelector(r3, r4, secondaryIds, null);
    }

    private static /* synthetic */ ProgramSelector.Identifier[] lambda$programSelectorFromHal$2(int x$0) {
        return new ProgramSelector.Identifier[x$0];
    }

    static {
        METADATA_KEYS = new SparseArray();
        ConvertIA r4 = null;
        METADATA_KEYS.put(1, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.RDS_PS", r4));
        METADATA_KEYS.put(2, new MetadataDef(MetadataType.INT, "android.hardware.radio.metadata.RDS_PTY", r4));
        METADATA_KEYS.put(3, new MetadataDef(MetadataType.INT, "android.hardware.radio.metadata.RBDS_PTY", r4));
        METADATA_KEYS.put(4, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.RDS_RT", r4));
        METADATA_KEYS.put(5, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.TITLE", r4));
        METADATA_KEYS.put(6, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.ARTIST", r4));
        METADATA_KEYS.put(7, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.ALBUM", r4));
        METADATA_KEYS.put(8, new MetadataDef(MetadataType.INT, "android.hardware.radio.metadata.ICON", r4));
        METADATA_KEYS.put(9, new MetadataDef(MetadataType.INT, "android.hardware.radio.metadata.ART", r4));
        METADATA_KEYS.put(10, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.PROGRAM_NAME", r4));
        METADATA_KEYS.put(11, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_ENSEMBLE_NAME", r4));
        METADATA_KEYS.put(12, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_ENSEMBLE_NAME_SHORT", r4));
        METADATA_KEYS.put(13, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_SERVICE_NAME", r4));
        METADATA_KEYS.put(14, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_SERVICE_NAME_SHORT", r4));
        METADATA_KEYS.put(15, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_COMPONENT_NAME", r4));
        METADATA_KEYS.put(16, new MetadataDef(MetadataType.STRING, "android.hardware.radio.metadata.DAB_COMPONENT_NAME_SHORT", r4));
    }

    private static RadioMetadata metadataFromHal(ArrayList<Metadata> meta) {
        RadioMetadata.Builder builder = new RadioMetadata.Builder();
        Iterator<Metadata> r1 = meta.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Metadata entry = r1.next();
        MetadataDef keyDef = METADATA_KEYS.get(entry.key);
        if (keyDef == null) goto L7;
        if (MetadataDef.m2831$$Nest$fgettype(keyDef) == MetadataType.STRING) goto L10;
        builder.putInt(MetadataDef.m2830$$Nest$fgetkey(keyDef), (int) entry.intValue);
        goto L4
    L10:
        builder.putString(MetadataDef.m2830$$Nest$fgetkey(keyDef), entry.stringValue);
        goto L4
    L7:
        Slogf.i(TAG, "Ignored unknown metadata entry: " + MetadataKey.toString(entry.key));
        goto L4
    L14:
        return builder.build();
    }

    static RadioManager.ProgramInfo programInfoFromHal(ProgramInfo info) {
        Collection<ProgramSelector.Identifier> relatedContent = (Collection) info.relatedContent.stream().map(new Convert$$ExternalSyntheticLambda5()).collect(Collectors.toList());
        ProgramSelector r2 = programSelectorFromHal(info.selector);
        r2.getClass();
        return new RadioManager.ProgramInfo(r2, programIdentifierFromHal(info.logicallyTunedTo), programIdentifierFromHal(info.physicallyTunedTo), relatedContent, info.infoFlags, info.signalQuality, metadataFromHal(info.metadata), vendorInfoFromHal(info.vendorInfo));
    }

    private static /* synthetic */ ProgramSelector.Identifier lambda$programInfoFromHal$3(ProgramIdentifier id) {
        ProgramSelector.Identifier r0 = programIdentifierFromHal(id);
        r0.getClass();
        return r0;
    }

    static ProgramFilter programFilterToHal(ProgramList.Filter filter) {
        if (filter != null) goto L4;
        filter = new ProgramList.Filter();
    L4:
        final ProgramFilter hwFilter = new ProgramFilter();
        Stream r1 = filter.getIdentifierTypes().stream();
        final ArrayList<Integer> r2 = hwFilter.identifierTypes;
        r2.getClass();
        r1.forEachOrdered(new Convert$$ExternalSyntheticLambda6(r2));
        filter.getIdentifiers().stream().forEachOrdered(new Convert$$ExternalSyntheticLambda7(hwFilter));
        hwFilter.includeCategories = filter.areCategoriesIncluded();
        hwFilter.excludeModifications = filter.areModificationsExcluded();
        return hwFilter;
    }

    private static /* synthetic */ void lambda$programFilterToHal$4(ProgramFilter hwFilter, ProgramSelector.Identifier id) {
        hwFilter.identifiers.add(programIdentifierToHal(id));
    }

    public static Announcement announcementFromHal(android.hardware.broadcastradio.V2_0.Announcement hwAnnouncement) {
        ProgramSelector r1 = programSelectorFromHal(hwAnnouncement.selector);
        r1.getClass();
        return new Announcement(r1, hwAnnouncement.type, vendorInfoFromHal(hwAnnouncement.vendorInfo));
    }

    static <T> ArrayList<T> listToArrayList(List<T> list) {
        if (list != null) goto L6;
        return null;
    L6:
        if ((list instanceof ArrayList) == false) goto L10;
        return (ArrayList) list;
    L10:
        return new ArrayList(list);
    }
}
