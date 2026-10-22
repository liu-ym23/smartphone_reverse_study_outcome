package stepos.com.android.os;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.util.List;
import stepos.com.google.protobuf.DescriptorProtos;

/* loaded from: classes.dex */
public final class AtomFieldOptions {
    public static final int STATE_FIELD_OPTION_FIELD_NUMBER = 50000;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, StateAtomFieldOption> stateFieldOption = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), StateAtomFieldOption.getDefaultInstance(), StateAtomFieldOption.getDefaultInstance(), null, STATE_FIELD_OPTION_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, StateAtomFieldOption.class);
    public static final int IS_UID_FIELD_NUMBER = 50001;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> isUid = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), false, null, null, IS_UID_FIELD_NUMBER, WireFormat.FieldType.BOOL, Boolean.class);
    public static final int LOG_MODE_FIELD_NUMBER = 50002;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, LogMode> logMode = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), LogMode.MODE_AUTOMATIC, null, LogMode.internalGetValueMap(), LOG_MODE_FIELD_NUMBER, WireFormat.FieldType.ENUM, LogMode.class);
    public static final int MODULE_FIELD_NUMBER = 50004;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, List<String>> module = GeneratedMessageLite.newRepeatedGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), null, null, MODULE_FIELD_NUMBER, WireFormat.FieldType.STRING, false, String.class);
    public static final int TRUNCATE_TIMESTAMP_FIELD_NUMBER = 50005;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, Boolean> truncateTimestamp = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), false, null, null, TRUNCATE_TIMESTAMP_FIELD_NUMBER, WireFormat.FieldType.BOOL, Boolean.class);
    public static final int RESTRICTION_CATEGORY_FIELD_NUMBER = 50006;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, RestrictionCategory> restrictionCategory = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), RestrictionCategory.RESTRICTION_UNSET, null, RestrictionCategory.internalGetValueMap(), RESTRICTION_CATEGORY_FIELD_NUMBER, WireFormat.FieldType.ENUM, RestrictionCategory.class);
    public static final int FIELD_RESTRICTION_OPTION_FIELD_NUMBER = 50007;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, FieldRestrictionOption> fieldRestrictionOption = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), FieldRestrictionOption.getDefaultInstance(), FieldRestrictionOption.getDefaultInstance(), null, FIELD_RESTRICTION_OPTION_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FieldRestrictionOption.class);
    public static final int HISTOGRAM_BIN_OPTION_FIELD_NUMBER = 50008;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FieldOptions, HistogramBinOption> histogramBinOption = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FieldOptions.getDefaultInstance(), HistogramBinOption.getDefaultInstance(), HistogramBinOption.getDefaultInstance(), null, HISTOGRAM_BIN_OPTION_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, HistogramBinOption.class);

    private AtomFieldOptions() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) stateFieldOption);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) isUid);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) logMode);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) module);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) truncateTimestamp);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) restrictionCategory);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) fieldRestrictionOption);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) histogramBinOption);
    }
}
