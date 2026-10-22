package f1;

import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.UninitializedMessageException;
import androidx.datastore.preferences.protobuf.WireFormat$FieldType;
import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.h;
import androidx.datastore.preferences.protobuf.i;
import androidx.datastore.preferences.protobuf.j0;
import androidx.datastore.preferences.protobuf.m;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.w0;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends GeneratedMessageLite<a, C0078a> implements j0 {
    private static final a DEFAULT_INSTANCE;
    private static volatile q0<a> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.f1760b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: f1.a$a, reason: collision with other inner class name */
    public static final class C0078a extends GeneratedMessageLite.a<a, C0078a> implements j0 {
        public C0078a() {
            super(a.DEFAULT_INSTANCE);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c0<String, PreferencesProto$Value> f8669a = new c0<>(WireFormat$FieldType.f1766c, WireFormat$FieldType.f1768e, PreferencesProto$Value.w());
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.m(a.class, aVar);
    }

    public static MapFieldLite o(a aVar) {
        MapFieldLite<String, PreferencesProto$Value> mapFieldLite = aVar.preferences_;
        if (!mapFieldLite.f1761a) {
            aVar.preferences_ = mapFieldLite.e();
        }
        return aVar.preferences_;
    }

    public static C0078a q() {
        return (C0078a) ((GeneratedMessageLite.a) DEFAULT_INSTANCE.i(GeneratedMessageLite.MethodToInvoke.f1744e));
    }

    public static a r(FileInputStream fileInputStream) {
        a aVar = DEFAULT_INSTANCE;
        h.b bVar = new h.b(fileInputStream);
        m mVarA = m.a();
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) aVar.i(GeneratedMessageLite.MethodToInvoke.f1743d);
        try {
            s0 s0Var = s0.f1880c;
            s0Var.getClass();
            w0 w0VarA = s0Var.a(generatedMessageLite.getClass());
            i iVar = bVar.f1826d;
            if (iVar == null) {
                iVar = new i(bVar);
            }
            w0VarA.a(generatedMessageLite, iVar, mVarA);
            w0VarA.b(generatedMessageLite);
            if (generatedMessageLite.l()) {
                return (a) generatedMessageLite;
            }
            throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
        } catch (IOException e10) {
            if (e10.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e10.getCause());
            }
            throw new InvalidProtocolBufferException(e10.getMessage());
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw e11;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object i(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        q0 bVar;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new u0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f8669a});
            case 3:
                return new a();
            case 4:
                return new C0078a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                q0<a> q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (a.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new GeneratedMessageLite.b();
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map<String, PreferencesProto$Value> p() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
