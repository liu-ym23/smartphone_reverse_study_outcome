package b7;

import com.google.protobuf.b3;
import com.google.protobuf.g2;
import com.google.protobuf.i2;
import com.google.protobuf.l;
import com.google.protobuf.p3;
import com.google.protobuf.s3;
import com.stepos.protobuf.connection.ToolOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends i2 implements ToolOrBuilder {
    private static final f DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int PARAMETERS_FIELD_NUMBER = 5;
    private static volatile p3 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private b3 parameters_ = b3.f2320g;
    private String id_ = "";
    private String version_ = "";
    private String name_ = "";
    private String description_ = "";

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        i2.n(f.class, fVar);
    }

    public static f p() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final boolean containsParameters(String str) {
        str.getClass();
        return this.parameters_.containsKey(str);
    }

    @Override // com.google.protobuf.i2
    public final Object d(int i2, i2 i2Var) {
        p3 g2Var;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new s3(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"id_", "version_", "name_", "description_", "parameters_", e.f1546a});
            case 3:
                return new f();
            case 4:
                return new a(2, DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                p3 p3Var = PARSER;
                if (p3Var != null) {
                    return p3Var;
                }
                synchronized (f.class) {
                    try {
                        g2Var = PARSER;
                        if (g2Var == null) {
                            g2Var = new g2();
                            PARSER = g2Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return g2Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final String getDescription() {
        return this.description_;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final l getDescriptionBytes() {
        return l.i(this.description_);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final String getId() {
        return this.id_;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final l getIdBytes() {
        return l.i(this.id_);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder, com.google.protobuf.DescriptorProtos$DescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FieldDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder, com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder, com.google.protobuf.EnumValueOrBuilder, com.google.protobuf.FieldOrBuilder, com.google.protobuf.MethodOrBuilder
    public final l getNameBytes() {
        return l.i(this.name_);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final Map getParameters() {
        return Collections.unmodifiableMap(this.parameters_);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final int getParametersCount() {
        return this.parameters_.size();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final Map getParametersMap() {
        return Collections.unmodifiableMap(this.parameters_);
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final String getParametersOrDefault(String str, String str2) {
        str.getClass();
        b3 b3Var = this.parameters_;
        return b3Var.containsKey(str) ? (String) b3Var.get(str) : str2;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final String getParametersOrThrow(String str) {
        str.getClass();
        b3 b3Var = this.parameters_;
        if (b3Var.containsKey(str)) {
            return (String) b3Var.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final String getVersion() {
        return this.version_;
    }

    @Override // com.stepos.protobuf.connection.ToolOrBuilder
    public final l getVersionBytes() {
        return l.i(this.version_);
    }
}
