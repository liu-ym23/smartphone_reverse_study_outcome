package com.android.server.broadcastradio.aidl;

import android.app.compat.CompatChanges;
import android.hardware.broadcastradio.Alert;
import android.hardware.broadcastradio.AlertArea;
import android.hardware.broadcastradio.AlertInfo;
import android.hardware.broadcastradio.AmFmRegionConfig;
import android.hardware.broadcastradio.DabTableEntry;
import android.hardware.broadcastradio.Geocode;
import android.hardware.broadcastradio.Metadata;
import android.hardware.broadcastradio.Polygon;
import android.hardware.broadcastradio.ProgramFilter;
import android.hardware.broadcastradio.ProgramIdentifier;
import android.hardware.broadcastradio.ProgramInfo;
import android.hardware.broadcastradio.Properties;
import android.hardware.broadcastradio.VendorKeyValue;
import android.hardware.radio.Announcement;
import android.hardware.radio.ProgramList;
import android.hardware.radio.ProgramSelector;
import android.hardware.radio.RadioAlert;
import android.hardware.radio.RadioManager;
import android.hardware.radio.RadioMetadata;
import android.hardware.radio.UniqueProgramIdentifier;
import android.os.ParcelableException;
import android.os.ServiceSpecificException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class ConversionUtils {
    public static final long RADIO_U_VERSION_REQUIRED = 261770108;
    public static final long RADIO_V_VERSION_REQUIRED = 302589903;
    private static final String TAG = "BcRadioAidlSrv.convert";

    public static /* synthetic */ ProgramIdentifier[] $r8$lambda$5BNW2R6Mrq7TNyIBTYq_zExTvbc(int r0) {
        return lambda$programSelectorToHalProgramSelector$2(r0);
    }

    public static /* synthetic */ RadioManager.BandDescriptor[] $r8$lambda$GjniY_a6MHpBUMB3Bwajra05_ZU(int r0) {
        return lambda$amfmConfigToBands$1(r0);
    }

    public static /* synthetic */ VendorKeyValue[] $r8$lambda$KZ7tTfXftYW6kEdF33oqtGf2JWE(int r0) {
        return lambda$vendorInfoToHalVendorKeyValues$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ddUIRVUf_qDHtPrR8GOfi-N3Vb4, reason: not valid java name */
    public static /* synthetic */ ProgramIdentifier[] m2805$r8$lambda$ddUIRVUf_qDHtPrR8GOfiN3Vb4(int r0) {
        return lambda$filterToHalProgramFilter$3(r0);
    }

    private ConversionUtils() {
        throw new UnsupportedOperationException("ConversionUtils class is noninstantiable");
    }

    static boolean isAtLeastU(int uid) {
        return CompatChanges.isChangeEnabled(RADIO_U_VERSION_REQUIRED, uid);
    }

    static boolean isAtLeastV(int uid) {
        return CompatChanges.isChangeEnabled(RADIO_V_VERSION_REQUIRED, uid);
    }

    static RuntimeException throwOnError(RuntimeException halException, String action) {
        if ((halException instanceof ServiceSpecificException) == false) goto L5;
        int result = ((ServiceSpecificException) halException).errorCode;
        switch(result) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        return new ParcelableException(new RuntimeException(action + ": unknown error (" + result + ")"));
    L11:
        return new ParcelableException(new RuntimeException(action + ": UNKNOWN_ERROR"));
    L13:
        return new IllegalStateException(action + ": CANCELED");
    L15:
        return new ParcelableException(new RuntimeException(action + ": TIMEOUT"));
    L17:
        return new UnsupportedOperationException(action + ": NOT_SUPPORTED");
    L19:
        return new IllegalStateException(action + ": INVALID_STATE");
    L21:
        return new IllegalArgumentException(action + ": INVALID_ARGUMENTS");
    L23:
        return new ParcelableException(new RuntimeException(action + ": INTERNAL_ERROR"));
    L5:
        return new ParcelableException(new RuntimeException(action + ": unknown error"));
    }

    static int halResultToTunerResult(int result) {
        switch(result) {
            case 0: goto L17;
            case 1: goto L15;
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
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    }

    static VendorKeyValue[] vendorInfoToHalVendorKeyValues(Map<String, String> info) {
        if (info == null) goto L4;
        ArrayList<VendorKeyValue> list = new ArrayList();
        Iterator<Map.Entry<String, String>> r1 = info.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        Map.Entry<String, String> entry = r1.next();
        VendorKeyValue elem = new VendorKeyValue();
        elem.key = entry.getKey();
        elem.value = entry.getValue();
        if (elem.key == null) goto L14;
        if (elem.value == null) goto L14;
        list.add(elem);
    L14:
        Slogf.w(TAG, "VendorKeyValue contains invalid entry: key = %s, value = %s", new Object[]{elem.key, elem.value});
        goto L7
    L16:
        return (VendorKeyValue[]) list.toArray(new ConversionUtils$$ExternalSyntheticLambda3());
    L4:
        return new VendorKeyValue[0];
    }

    private static /* synthetic */ VendorKeyValue[] lambda$vendorInfoToHalVendorKeyValues$0(int x$0) {
        return new VendorKeyValue[x$0];
    }

    static Map<String, String> vendorInfoFromHalVendorKeyValues(VendorKeyValue[] info) {
        if (info == null) goto L4;
        Map<String, String> map = new ArrayMap();
        int r1 = info.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L15;
        VendorKeyValue kvp = info[r2];
        if (kvp.key != null) goto L10;
    L13:
        Slogf.w(TAG, "VendorKeyValue contains invalid entry: key = %s, value = %s", new Object[]{kvp.key, kvp.value});
    L14:
        r2 = r2 + 1;
        goto L6
    L10:
        if (kvp.value == null) goto L13;
        map.put(kvp.key, kvp.value);
        goto L14
    L15:
        return map;
    L4:
        return Collections.emptyMap();
    }

    private static int identifierTypeToProgramType(int idType) {
        switch(idType) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L20;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L18;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L16;
            case 12: goto L14;
            case 13: goto L14;
            case 14: goto L18;
            case 10004: goto L20;
            default: goto L5;
        };
    L14:
        return 7;
    L16:
        return 6;
    L18:
        return 5;
    L20:
        return 4;
    L21:
        return 2;
    L5:
        if (idType != 15) goto L8;
        return 4;
    L8:
        if (idType >= 1000) goto L10;
        return 0;
    L10:
        if (idType > 1999) goto L23;
        return idType;
    L23:
        return 0;
    }

    private static int[] identifierTypesToProgramTypes(int[] idTypes) {
        Set<Integer> programTypes = new ArraySet();
        int i = 0;
    L4:
        if (i >= idTypes.length) goto L15;
        int pType = identifierTypeToProgramType(idTypes[i]);
        if (pType == 0) goto L14;
        programTypes.add(Integer.valueOf(pType));
        if (pType != 2) goto L12;
        programTypes.add(1);
    L12:
        if (pType != 4) goto L14;
        programTypes.add(3);
    L14:
        i = i + 1;
        goto L4
    L15:
        int i2 = programTypes.size();
        int[] programTypesArray = new int[i2];
        int i3 = 0;
        Iterator<Integer> r3 = programTypes.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        int programType = r3.next().intValue();
        programTypesArray[i3] = programType;
        i3 = i3 + 1;
        goto L17
    L19:
        return programTypesArray;
    }

    private static RadioManager.BandDescriptor[] amfmConfigToBands(AmFmRegionConfig config) {
        if (config == null) goto L4;
        int len = config.ranges.length;
        List<RadioManager.BandDescriptor> bands = new ArrayList();
        int i = 0;
    L6:
        if (i >= len) goto L16;
        Utils.FrequencyBand bandType = Utils.getBand(config.ranges[i].lowerBound);
        if (bandType != Utils.FrequencyBand.UNKNOWN) goto L11;
        Slogf.e(TAG, "Unknown frequency band at %d kHz", new Object[]{Integer.valueOf(config.ranges[i].lowerBound)});
    L14:
        i = i + 1;
        goto L6
    L11:
        if (bandType != Utils.FrequencyBand.FM) goto L13;
        bands.add(new RadioManager.FmBandDescriptor(0, 1, config.ranges[i].lowerBound, config.ranges[i].upperBound, config.ranges[i].spacing, true, true, true, true, true));
        goto L14
    L13:
        bands.add(new RadioManager.AmBandDescriptor(0, 0, config.ranges[i].lowerBound, config.ranges[i].upperBound, config.ranges[i].spacing, true));
        goto L14
    L16:
        return (RadioManager.BandDescriptor[]) bands.toArray(new ConversionUtils$$ExternalSyntheticLambda0());
    L4:
        return new RadioManager.BandDescriptor[0];
    }

    private static /* synthetic */ RadioManager.BandDescriptor[] lambda$amfmConfigToBands$1(int x$0) {
        return new RadioManager.BandDescriptor[x$0];
    }

    private static Map<String, Integer> dabConfigFromHalDabTableEntries(DabTableEntry[] config) {
        if (config != null) goto L5;
        return null;
    L5:
        Map<String, Integer> dabConfig = new ArrayMap();
        int i = 0;
    L7:
        if (i >= config.length) goto L10;
        dabConfig.put(config[i].label, Integer.valueOf(config[i].frequencyKhz));
        i = i + 1;
        goto L7
    L10:
        return dabConfig;
    }

    static RadioManager.ModuleProperties propertiesFromHalProperties(int id, String serviceName, Properties prop, AmFmRegionConfig amfmConfig, DabTableEntry[] dabConfig) {
        serviceName.getClass();
        prop.getClass();
        int[] supportedProgramTypes = identifierTypesToProgramTypes(prop.supportedIdentifierTypes);
        return new RadioManager.ModuleProperties(id, serviceName, 0, prop.maker, prop.product, prop.version, prop.serial, 1, 1, false, false, amfmConfigToBands(amfmConfig), true, supportedProgramTypes, prop.supportedIdentifierTypes, dabConfigFromHalDabTableEntries(dabConfig), vendorInfoFromHalVendorKeyValues(prop.vendorInfo));
    }

    static ProgramIdentifier identifierToHalProgramIdentifier(ProgramSelector.Identifier id) {
        ProgramIdentifier hwId = new ProgramIdentifier();
        if (id.getType() != 14) goto L6;
        hwId.type = 5;
    L9:
        long value = id.getValue();
        if (id.getType() != 5) goto L12;
        hwId.value = (65535 & value) | ((value >>> 16) << 32);
    L13:
        return hwId;
    L12:
        hwId.value = value;
        goto L13
    L6:
        if (id.getType() != 15) goto L8;
        hwId.type = 14;
        goto L9
    L8:
        hwId.type = id.getType();
        goto L9
    }

    static ProgramSelector.Identifier identifierFromHalProgramIdentifier(ProgramIdentifier id) {
        if (id.type != 0) goto L7;
        return null;
    L7:
        if (id.type != 5) goto L9;
        int idType = 14;
    L14:
        return new ProgramSelector.Identifier(idType, id.value);
    L9:
        int idType2 = id.type;
        if (idType2 != 14) goto L12;
        idType = 15;
        goto L14
    L12:
        idType = id.type;
        goto L14
    }

    private static boolean isVendorIdentifierType(int idType) {
        if (idType >= 1000) goto L5;
    L7:
        return false;
    L5:
        if (idType > 1999) goto L7;
        return true;
    }

    private static boolean isValidHalProgramSelector(android.hardware.broadcastradio.ProgramSelector sel) {
        if (sel.primaryId.type != 1) goto L5;
        return true;
    L5:
        if (sel.primaryId.type != 2) goto L7;
        return true;
    L7:
        if (sel.primaryId.type != 3) goto L9;
        return true;
    L9:
        if (sel.primaryId.type != 5) goto L11;
        return true;
    L11:
        if (sel.primaryId.type != 9) goto L13;
        return true;
    L13:
        if (sel.primaryId.type != 12) goto L15;
        return true;
    L15:
        if (isVendorIdentifierType(sel.primaryId.type) == true) goto L26;
        return false;
    L26:
        return true;
    }

    static android.hardware.broadcastradio.ProgramSelector programSelectorToHalProgramSelector(ProgramSelector sel) {
        android.hardware.broadcastradio.ProgramSelector hwSel = new android.hardware.broadcastradio.ProgramSelector();
        hwSel.primaryId = identifierToHalProgramIdentifier(sel.getPrimaryId());
        ProgramSelector.Identifier[] secondaryIds = sel.getSecondaryIds();
        ArrayList<ProgramIdentifier> secondaryIdList = new ArrayList(secondaryIds.length);
        int i = 0;
    L4:
        if (i >= secondaryIds.length) goto L10;
        ProgramIdentifier hwId = identifierToHalProgramIdentifier(secondaryIds[i]);
        if (hwId.type == 0) goto L8;
        secondaryIdList.add(hwId);
    L9:
        i = i + 1;
        goto L4
    L8:
        Slogf.w(TAG, "Invalid secondary id: %s", new Object[]{secondaryIds[i]});
        goto L9
    L10:
        hwSel.secondaryIds = (ProgramIdentifier[]) secondaryIdList.toArray(new ConversionUtils$$ExternalSyntheticLambda2());
        if (isValidHalProgramSelector(hwSel) == true) goto L14;
        return null;
    L14:
        return hwSel;
    }

    private static /* synthetic */ ProgramIdentifier[] lambda$programSelectorToHalProgramSelector$2(int x$0) {
        return new ProgramIdentifier[x$0];
    }

    private static boolean isEmpty(android.hardware.broadcastradio.ProgramSelector sel) {
        if (sel.primaryId.type == 0) goto L5;
    L9:
        return false;
    L5:
        if (sel.primaryId.value != 0) goto L9;
        if (sel.secondaryIds.length != 0) goto L9;
        return true;
    }

    static ProgramSelector programSelectorFromHalProgramSelector(android.hardware.broadcastradio.ProgramSelector sel) {
        if (isEmpty(sel) == false) goto L5;
    L19:
        return null;
    L5:
        if (isValidHalProgramSelector(sel) == false) goto L19;
        List<ProgramSelector.Identifier> secondaryIdList = new ArrayList();
        int i = 0;
    L9:
        if (i >= sel.secondaryIds.length) goto L17;
        if (sel.secondaryIds[i] == null) goto L16;
        ProgramSelector.Identifier id = identifierFromHalProgramIdentifier(sel.secondaryIds[i]);
        if (id != null) goto L15;
        Slogf.e(TAG, "invalid secondary id: %s", new Object[]{sel.secondaryIds[i]});
        goto L16
    L15:
        secondaryIdList.add(id);
    L16:
        i = i + 1;
        goto L9
    L17:
        int r3 = identifierTypeToProgramType(sel.primaryId.type);
        ProgramSelector.Identifier r4 = identifierFromHalProgramIdentifier(sel.primaryId);
        r4.getClass();
        return new ProgramSelector(r3, r4, (ProgramSelector.Identifier[]) secondaryIdList.toArray(new ProgramSelector.Identifier[0]), null);
    }

    static RadioMetadata radioMetadataFromHalMetadata(Metadata[] meta) {
        RadioMetadata.Builder builder = new RadioMetadata.Builder();
        int i = 0;
    L4:
        if (i >= meta.length) goto L35;
        int tag = meta[i].getTag();
        switch(tag) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            default: goto L7;
        };
    L7:
        switch(tag) {
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            default: goto L8;
        };
    L8:
        Slogf.w(TAG, "Ignored unknown metadata entry: %s with HD radio flag enabled", new Object[]{meta[i]});
    L33:
        i = i + 1;
        goto L4
    L9:
        builder.putInt("android.hardware.radio.metadata.HD_SUBCHANNELS_AVAILABLE", meta[i].getHdSubChannelsAvailable());
        goto L33
    L10:
        builder.putString("android.hardware.radio.metadata.HD_STATION_NAME_LONG", meta[i].getHdStationNameLong());
        goto L33
    L11:
        builder.putString("android.hardware.radio.metadata.HD_STATION_NAME_SHORT", meta[i].getHdStationNameShort());
        goto L33
    L12:
        builder.putStringArray("android.hardware.radio.metadata.UFIDS", meta[i].getUfids());
        goto L33
    L13:
        builder.putString("android.hardware.radio.metadata.COMMERCIAL", meta[i].getCommercial());
        goto L33
    L14:
        builder.putString("android.hardware.radio.metadata.COMMENT_ACTUAL_TEXT", meta[i].getCommentActualText());
        goto L33
    L15:
        builder.putString("android.hardware.radio.metadata.COMMENT_SHORT_DESCRIPTION", meta[i].getCommentShortDescription());
        goto L33
    L16:
        builder.putString("android.hardware.radio.metadata.GENRE", meta[i].getGenre());
        goto L33
    L17:
        builder.putString("android.hardware.radio.metadata.DAB_COMPONENT_NAME_SHORT", meta[i].getDabComponentNameShort());
        goto L33
    L18:
        builder.putString("android.hardware.radio.metadata.DAB_COMPONENT_NAME", meta[i].getDabComponentName());
        goto L33
    L19:
        builder.putString("android.hardware.radio.metadata.DAB_SERVICE_NAME_SHORT", meta[i].getDabServiceNameShort());
        goto L33
    L20:
        builder.putString("android.hardware.radio.metadata.DAB_SERVICE_NAME", meta[i].getDabServiceName());
        goto L33
    L21:
        builder.putString("android.hardware.radio.metadata.DAB_ENSEMBLE_NAME_SHORT", meta[i].getDabEnsembleNameShort());
        goto L33
    L22:
        builder.putString("android.hardware.radio.metadata.DAB_ENSEMBLE_NAME", meta[i].getDabEnsembleName());
        goto L33
    L23:
        builder.putString("android.hardware.radio.metadata.PROGRAM_NAME", meta[i].getProgramName());
        goto L33
    L24:
        builder.putInt("android.hardware.radio.metadata.ART", meta[i].getAlbumArt());
        goto L33
    L25:
        builder.putInt("android.hardware.radio.metadata.ICON", meta[i].getStationIcon());
        goto L33
    L26:
        builder.putString("android.hardware.radio.metadata.ALBUM", meta[i].getSongAlbum());
        goto L33
    L27:
        builder.putString("android.hardware.radio.metadata.ARTIST", meta[i].getSongArtist());
        goto L33
    L28:
        builder.putString("android.hardware.radio.metadata.TITLE", meta[i].getSongTitle());
        goto L33
    L29:
        builder.putString("android.hardware.radio.metadata.RDS_RT", meta[i].getRdsRt());
        goto L33
    L30:
        builder.putInt("android.hardware.radio.metadata.RBDS_PTY", meta[i].getRbdsPty());
        goto L33
    L31:
        builder.putInt("android.hardware.radio.metadata.RDS_PTY", meta[i].getRdsPty());
        goto L33
    L32:
        builder.putString("android.hardware.radio.metadata.RDS_PS", meta[i].getRdsPs());
        goto L33
    L35:
        return builder.build();
    }

    private static RadioAlert.Polygon polygonFromHalPolygon(Polygon halPolygon) {
        if (halPolygon.coordinates.length >= 4) goto L7;
        Slogf.e(TAG, "Number of coordinates in alert polygon cannot be less than 4");
        return null;
    L7:
        if (halPolygon.coordinates[0].latitude == halPolygon.coordinates[halPolygon.coordinates.length - 1].latitude) goto L9;
    L17:
        Slogf.e(TAG, "The first and the last coordinate in alert polygon cannot be different");
        return null;
    L9:
        if (halPolygon.coordinates[0].longitude != halPolygon.coordinates[halPolygon.coordinates.length - 1].longitude) goto L17;
        List<RadioAlert.Coordinate> coordinates = new ArrayList(halPolygon.coordinates.length);
        int idx = 0;
    L13:
        if (idx >= halPolygon.coordinates.length) goto L16;
        coordinates.add(new RadioAlert.Coordinate(halPolygon.coordinates[idx].latitude, halPolygon.coordinates[idx].longitude));
        idx = idx + 1;
        goto L13
    L16:
        return new RadioAlert.Polygon(coordinates);
    }

    private static RadioAlert.Geocode geocodeFromHalGeocode(Geocode geocode) {
        return new RadioAlert.Geocode(geocode.valueName, geocode.value);
    }

    private static RadioAlert.AlertArea alertAreaFromHalAlertArea(AlertArea halAlertArea) {
        List<RadioAlert.Polygon> polygonList = new ArrayList();
        int idx = 0;
    L4:
        if (idx >= halAlertArea.polygons.length) goto L9;
        RadioAlert.Polygon polygon = polygonFromHalPolygon(halAlertArea.polygons[idx]);
        if (polygon == null) goto L8;
        polygonList.add(polygon);
    L8:
        idx = idx + 1;
        goto L4
    L9:
        List<RadioAlert.Geocode> geocodeList = new ArrayList(halAlertArea.geocodes.length);
        int idx2 = 0;
    L11:
        if (idx2 >= halAlertArea.geocodes.length) goto L14;
        geocodeList.add(geocodeFromHalGeocode(halAlertArea.geocodes[idx2]));
        idx2 = idx2 + 1;
        goto L11
    L14:
        return new RadioAlert.AlertArea(polygonList, geocodeList);
    }

    private static RadioAlert.AlertInfo alertInfoFromHalAlertInfo(AlertInfo halAlertInfo) {
        int[] categoryArray = new int[halAlertInfo.categoryArray.length];
        int idx = 0;
    L4:
        if (idx >= halAlertInfo.categoryArray.length) goto L6;
        categoryArray[idx] = halAlertInfo.categoryArray[idx];
        idx = idx + 1;
        goto L4
    L6:
        List<RadioAlert.AlertArea> alertAreaList = new ArrayList();
        int idx2 = 0;
    L8:
        if (idx2 >= halAlertInfo.areas.length) goto L11;
        alertAreaList.add(alertAreaFromHalAlertArea(halAlertInfo.areas[idx2]));
        idx2 = idx2 + 1;
        goto L8
    L11:
        return new RadioAlert.AlertInfo(categoryArray, halAlertInfo.urgency, halAlertInfo.severity, halAlertInfo.certainty, halAlertInfo.description, alertAreaList, halAlertInfo.language);
    }

    static RadioAlert radioAlertFromHalAlert(Alert halAlert) {
        if (halAlert != null) goto L5;
        return null;
    L5:
        List<RadioAlert.AlertInfo> alertInfo = new ArrayList(halAlert.infoArray.length);
        int idx = 0;
    L7:
        if (idx >= halAlert.infoArray.length) goto L10;
        alertInfo.add(alertInfoFromHalAlertInfo(halAlert.infoArray[idx]));
        idx = idx + 1;
        goto L7
    L10:
        return new RadioAlert(halAlert.status, halAlert.messageType, alertInfo);
    }

    private static boolean isValidLogicallyTunedTo(ProgramIdentifier id) {
        if (id.type != 1) goto L5;
        return true;
    L5:
        if (id.type != 2) goto L7;
        return true;
    L7:
        if (id.type != 3) goto L9;
        return true;
    L9:
        if (id.type != 5) goto L11;
        return true;
    L11:
        if (id.type != 9) goto L13;
        return true;
    L13:
        if (id.type != 12) goto L15;
        return true;
    L15:
        if (isVendorIdentifierType(id.type) == true) goto L26;
        return false;
    L26:
        return true;
    }

    private static boolean isValidPhysicallyTunedTo(ProgramIdentifier id) {
        if (id.type != 1) goto L5;
        return true;
    L5:
        if (id.type != 8) goto L7;
        return true;
    L7:
        if (id.type != 10) goto L9;
        return true;
    L9:
        if (id.type != 13) goto L11;
        return true;
    L11:
        if (isVendorIdentifierType(id.type) == true) goto L20;
        return false;
    L20:
        return true;
    }

    static RadioManager.ProgramInfo programInfoFromHalProgramInfo(ProgramInfo info) {
        if (isValidHalProgramSelector(info.selector) == true) goto L6;
        return null;
    L6:
        Collection<ProgramSelector.Identifier> relatedContent = new ArrayList();
        if (info.relatedContent == null) goto L15;
        int i = 0;
    L10:
        if (i >= info.relatedContent.length) goto L15;
        ProgramSelector.Identifier relatedContentId = identifierFromHalProgramIdentifier(info.relatedContent[i]);
        if (relatedContentId == null) goto L14;
        relatedContent.add(relatedContentId);
    L14:
        i = i + 1;
    L15:
        ProgramSelector r2 = programSelectorFromHalProgramSelector(info.selector);
        r2.getClass();
        return new RadioManager.ProgramInfo(r2, identifierFromHalProgramIdentifier(info.logicallyTunedTo), identifierFromHalProgramIdentifier(info.physicallyTunedTo), relatedContent, info.infoFlags, info.signalQuality, radioMetadataFromHalMetadata(info.metadata), vendorInfoFromHalVendorKeyValues(info.vendorInfo), radioAlertFromHalAlert(info.emergencyAlert));
    }

    static RadioManager.ProgramInfo tunedProgramInfoFromHalProgramInfo(ProgramInfo info) {
        if (isValidLogicallyTunedTo(info.logicallyTunedTo) == true) goto L5;
        return null;
    L5:
        if (isValidPhysicallyTunedTo(info.physicallyTunedTo) == true) goto L8;
        return null;
    L8:
        return programInfoFromHalProgramInfo(info);
    }

    static ProgramFilter filterToHalProgramFilter(ProgramList.Filter filter) {
        if (filter != null) goto L4;
        filter = new ProgramList.Filter();
    L4:
        ProgramFilter hwFilter = new ProgramFilter();
        IntArray identifierTypeList = new IntArray(filter.getIdentifierTypes().size());
        ArrayList<ProgramIdentifier> identifiersList = new ArrayList();
        Iterator<Integer> typeIterator = filter.getIdentifierTypes().iterator();
    L6:
        if (typeIterator.hasNext() == false) goto L8;
        identifierTypeList.add(typeIterator.next().intValue());
        goto L6
    L8:
        Iterator<ProgramSelector.Identifier> idIterator = filter.getIdentifiers().iterator();
    L10:
        if (idIterator.hasNext() == false) goto L16;
        ProgramSelector.Identifier id = idIterator.next();
        ProgramIdentifier hwId = identifierToHalProgramIdentifier(id);
        if (hwId.type != 0) goto L13;
        Slogf.w(TAG, "Invalid identifiers: %s", new Object[]{id});
        goto L10
    L13:
        identifiersList.add(hwId);
        goto L10
    L16:
        hwFilter.identifierTypes = identifierTypeList.toArray();
        hwFilter.identifiers = (ProgramIdentifier[]) identifiersList.toArray(new ConversionUtils$$ExternalSyntheticLambda1());
        hwFilter.includeCategories = filter.areCategoriesIncluded();
        hwFilter.excludeModifications = filter.areModificationsExcluded();
        return hwFilter;
    }

    private static /* synthetic */ ProgramIdentifier[] lambda$filterToHalProgramFilter$3(int x$0) {
        return new ProgramIdentifier[x$0];
    }

    private static boolean identifierMeetsSdkVersionRequirement(ProgramSelector.Identifier id, int uid) {
        if (isAtLeastV(uid) == true) goto L8;
        if (id.getType() != 15) goto L8;
        return false;
    L8:
        if (isAtLeastU(uid) == false) goto L10;
        return true;
    L10:
        if (id.getType() != 14) goto L12;
        return false;
    L12:
        return true;
    }

    static boolean programSelectorMeetsSdkVersionRequirement(ProgramSelector sel, int uid) {
        if (identifierMeetsSdkVersionRequirement(sel.getPrimaryId(), uid) == true) goto L5;
        return false;
    L5:
        ProgramSelector.Identifier[] secondaryIds = sel.getSecondaryIds();
        int i = 0;
    L7:
        if (i >= secondaryIds.length) goto L12;
        if (identifierMeetsSdkVersionRequirement(secondaryIds[i], uid) == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    static boolean programInfoMeetsSdkVersionRequirement(RadioManager.ProgramInfo info, int uid) {
        if (programSelectorMeetsSdkVersionRequirement(info.getSelector(), uid) == true) goto L6;
        return false;
    L6:
        if (info.getLogicallyTunedTo() == null) goto L10;
        if (identifierMeetsSdkVersionRequirement(info.getLogicallyTunedTo(), uid) == true) goto L10;
    L13:
        return false;
    L10:
        if (info.getPhysicallyTunedTo() != null) goto L12;
    L14:
        Iterator<ProgramSelector.Identifier> relatedContentIt = info.getRelatedContent().iterator();
    L16:
        if (relatedContentIt.hasNext() == false) goto L20;
        if (identifierMeetsSdkVersionRequirement(relatedContentIt.next(), uid) == true) goto L16;
        return false;
    L20:
        return true;
    L12:
        if (identifierMeetsSdkVersionRequirement(info.getPhysicallyTunedTo(), uid) == true) goto L14;
        goto L13
    }

    static ProgramList.Chunk convertChunkToTargetSdkVersion(ProgramList.Chunk chunk, int uid) {
        Set<RadioManager.ProgramInfo> modified = new ArraySet();
        Iterator<RadioManager.ProgramInfo> modifiedIterator = chunk.getModified().iterator();
    L4:
        if (modifiedIterator.hasNext() == false) goto L9;
        RadioManager.ProgramInfo info = modifiedIterator.next();
        if (programInfoMeetsSdkVersionRequirement(info, uid) == false) goto L4;
        modified.add(info);
        goto L4
    L9:
        Set<UniqueProgramIdentifier> removed = new ArraySet();
        Iterator<UniqueProgramIdentifier> removedIterator = chunk.getRemoved().iterator();
    L11:
        if (removedIterator.hasNext() == false) goto L17;
        UniqueProgramIdentifier id = removedIterator.next();
        if (identifierMeetsSdkVersionRequirement(id.getPrimaryId(), uid) == false) goto L11;
        removed.add(id);
        goto L11
    L17:
        return new ProgramList.Chunk(chunk.isPurge(), chunk.isComplete(), modified, removed);
    }

    static boolean configFlagMeetsSdkVersionRequirement(int configFlag, int uid) {
        if (isAtLeastV(uid) == false) goto L5;
        return true;
    L5:
        if (configFlag != 11) goto L7;
    L9:
        return false;
    L7:
        if (configFlag == 10) goto L9;
        return true;
    }

    public static Announcement announcementFromHalAnnouncement(android.hardware.broadcastradio.Announcement hwAnnouncement) {
        ProgramSelector r1 = programSelectorFromHalProgramSelector(hwAnnouncement.selector);
        r1.getClass();
        return new Announcement(r1, hwAnnouncement.type, vendorInfoFromHalVendorKeyValues(hwAnnouncement.vendorInfo));
    }
}
