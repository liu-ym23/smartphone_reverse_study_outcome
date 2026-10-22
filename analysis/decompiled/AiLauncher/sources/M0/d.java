package M0;

import J0.i;
import L0.d;
import M0.a;
import Y8.t;
import Z8.F;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.core.MutablePreferences;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u00148\u0006X\u0086D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"LM0/d;", "LJ0/i;", "LM0/a;", "<init>", "()V", "Ljava/io/InputStream;", "input", Const.INTENT_KEY_APIKEY, "(Ljava/io/InputStream;Le9/c;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LM0/a;Ljava/io/OutputStream;Le9/c;)Ljava/lang/Object;", "", UxipConstants.f30680s, "Landroidx/datastore/preferences/PreferencesProto$Value;", "f", "(Ljava/lang/Object;)Landroidx/datastore/preferences/PreferencesProto$Value;", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "c", "(Ljava/lang/String;Landroidx/datastore/preferences/PreferencesProto$Value;Landroidx/datastore/preferences/core/MutablePreferences;)V", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "fileExtension", Const.INTENT_KEY_UMID, "()LM0/a;", "defaultValue", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class d implements i<M0.a> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4498a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final String fileExtension = "preferences_pb";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4500a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            iArr[PreferencesProto$Value.ValueCase.BOOLEAN.ordinal()] = 1;
            iArr[PreferencesProto$Value.ValueCase.FLOAT.ordinal()] = 2;
            iArr[PreferencesProto$Value.ValueCase.DOUBLE.ordinal()] = 3;
            iArr[PreferencesProto$Value.ValueCase.INTEGER.ordinal()] = 4;
            iArr[PreferencesProto$Value.ValueCase.LONG.ordinal()] = 5;
            iArr[PreferencesProto$Value.ValueCase.STRING.ordinal()] = 6;
            iArr[PreferencesProto$Value.ValueCase.STRING_SET.ordinal()] = 7;
            iArr[PreferencesProto$Value.ValueCase.VALUE_NOT_SET.ordinal()] = 8;
            f4500a = iArr;
        }
    }

    @Override // J0.i
    public Object a(InputStream inputStream, InterfaceC4014c<? super M0.a> interfaceC4014c) throws IOException {
        L0.d dVarA = L0.b.INSTANCE.a(inputStream);
        MutablePreferences mutablePreferencesB = b.b(new a.b[0]);
        Map<String, PreferencesProto$Value> mapF = dVarA.F();
        p.h(mapF, "preferencesProto.preferencesMap");
        for (Map.Entry<String, PreferencesProto$Value> entry : mapF.entrySet()) {
            String name = entry.getKey();
            PreferencesProto$Value value = entry.getValue();
            d dVar = f4498a;
            p.h(name, "name");
            p.h(value, "value");
            dVar.c(name, value, mutablePreferencesB);
        }
        return mutablePreferencesB.d();
    }

    public final void c(String name, PreferencesProto$Value value, MutablePreferences mutablePreferences) throws CorruptionException {
        PreferencesProto$Value.ValueCase valueCaseS = value.S();
        switch (valueCaseS == null ? -1 : a.f4500a[valueCaseS.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                mutablePreferences.i(c.a(name), Boolean.valueOf(value.K()));
                return;
            case 2:
                mutablePreferences.i(c.c(name), Float.valueOf(value.N()));
                return;
            case 3:
                mutablePreferences.i(c.b(name), Double.valueOf(value.M()));
                return;
            case 4:
                mutablePreferences.i(c.d(name), Integer.valueOf(value.O()));
                return;
            case 5:
                mutablePreferences.i(c.e(name), Long.valueOf(value.P()));
                return;
            case 6:
                a.C0079a<String> c0079aF = c.f(name);
                String strQ = value.Q();
                p.h(strQ, "value.string");
                mutablePreferences.i(c0079aF, strQ);
                return;
            case 7:
                a.C0079a<Set<String>> c0079aG = c.g(name);
                List<String> listH = value.R().H();
                p.h(listH, "value.stringSet.stringsList");
                mutablePreferences.i(c0079aG, F.r1(listH));
                return;
            case 8:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    @Override // J0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public M0.a getDefaultValue() {
        return b.a();
    }

    public final String e() {
        return fileExtension;
    }

    public final PreferencesProto$Value f(Object value) {
        if (value instanceof Boolean) {
            PreferencesProto$Value preferencesProto$ValueBuild = PreferencesProto$Value.T().t(((Boolean) value).booleanValue()).build();
            p.h(preferencesProto$ValueBuild, "newBuilder().setBoolean(value).build()");
            return preferencesProto$ValueBuild;
        }
        if (value instanceof Float) {
            PreferencesProto$Value preferencesProto$ValueBuild2 = PreferencesProto$Value.T().v(((Number) value).floatValue()).build();
            p.h(preferencesProto$ValueBuild2, "newBuilder().setFloat(value).build()");
            return preferencesProto$ValueBuild2;
        }
        if (value instanceof Double) {
            PreferencesProto$Value preferencesProto$ValueBuild3 = PreferencesProto$Value.T().u(((Number) value).doubleValue()).build();
            p.h(preferencesProto$ValueBuild3, "newBuilder().setDouble(value).build()");
            return preferencesProto$ValueBuild3;
        }
        if (value instanceof Integer) {
            PreferencesProto$Value preferencesProto$ValueBuild4 = PreferencesProto$Value.T().w(((Number) value).intValue()).build();
            p.h(preferencesProto$ValueBuild4, "newBuilder().setInteger(value).build()");
            return preferencesProto$ValueBuild4;
        }
        if (value instanceof Long) {
            PreferencesProto$Value preferencesProto$ValueBuild5 = PreferencesProto$Value.T().x(((Number) value).longValue()).build();
            p.h(preferencesProto$ValueBuild5, "newBuilder().setLong(value).build()");
            return preferencesProto$ValueBuild5;
        }
        if (value instanceof String) {
            PreferencesProto$Value preferencesProto$ValueBuild6 = PreferencesProto$Value.T().y((String) value).build();
            p.h(preferencesProto$ValueBuild6, "newBuilder().setString(value).build()");
            return preferencesProto$ValueBuild6;
        }
        if (!(value instanceof Set)) {
            throw new IllegalStateException(p.r("PreferencesSerializer does not support type: ", value.getClass().getName()));
        }
        PreferencesProto$Value preferencesProto$ValueBuild7 = PreferencesProto$Value.T().z(androidx.datastore.preferences.a.I().t((Set) value)).build();
        p.h(preferencesProto$ValueBuild7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
        return preferencesProto$ValueBuild7;
    }

    @Override // J0.i
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Object b(M0.a aVar, OutputStream outputStream, InterfaceC4014c<? super t> interfaceC4014c) throws IOException {
        Map<a.C0079a<?>, Object> mapA = aVar.a();
        d.a aVarI = L0.d.I();
        for (Map.Entry<a.C0079a<?>, Object> entry : mapA.entrySet()) {
            aVarI.t(entry.getKey().getName(), f(entry.getValue()));
        }
        aVarI.build().h(outputStream);
        return t.f7040a;
    }
}
