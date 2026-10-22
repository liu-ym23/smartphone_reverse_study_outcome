package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.store.kv.IKVStore;
import com.stepos.cloudsdk.Constants;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ-\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u001bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applog/alink/ALinkCache;", "", Constants.PATH_CONFIG, "Lcom/bytedance/applog/InitConfig;", "context", "Landroid/content/Context;", "spName", "", "(Lcom/bytedance/applog/InitConfig;Landroid/content/Context;Ljava/lang/String;)V", "aLinkKVStore", "Lcom/bytedance/applog/store/kv/IKVStore;", "getALinkKVStore", "()Lcom/bytedance/applog/store/kv/IKVStore;", "aLinkKVStore$delegate", "Lkotlin/Lazy;", "getData", "T", "Lcom/bytedance/applog/alink/model/BaseData;", Constants.COLUMN_KEY, "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/applog/alink/model/BaseData;", "getString", "putData", "", ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA, "expireTs", "", "putString", "value", "Companion", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class h {
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(h.class), "aLinkKVStore", "getALinkKVStore()Lcom/bytedance/applog/store/kv/IKVStore;"))};
    public final Lazy a;

    public static final class a extends Lambda implements Function0<IKVStore> {
        public final /* synthetic */ InitConfig a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InitConfig initConfig, Context context, String str) {
            super(0);
            this.a = initConfig;
            this.b = context;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public IKVStore invoke() {
            return v4.a(this.a, this.b, this.c);
        }
    }

    public h(InitConfig config, Context context, String spName) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(spName, "spName");
        this.a = LazyKt.lazy(new a(config, context, spName));
    }

    public final IKVStore a() {
        Lazy lazy = this.a;
        KProperty kProperty = b[0];
        return (IKVStore) lazy.getValue();
    }

    public final <T extends p> T a(String key, Class<T> clazz) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        try {
            String string = a().getString(key, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                long jOptLong = jSONObject.optLong("expire_ts");
                if (jOptLong != -1 && (jOptLong <= 0 || System.currentTimeMillis() >= jOptLong)) {
                    a().remove(key);
                }
                return (T) p.a.a(jSONObject, clazz);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final String a(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            String string = a().getString(key, null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                long jOptLong = jSONObject.optLong("expire_ts");
                if (jOptLong != -1 && (jOptLong <= 0 || System.currentTimeMillis() >= jOptLong)) {
                    a().remove(key);
                }
                return jSONObject.optString(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void a(String key, p data, long j) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        JSONObject jSONObjectA = data.a();
        jSONObjectA.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        a().putString(key, jSONObjectA.toString());
    }

    public final void a(String key, String str, long j) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA, str);
        jSONObject.put("expire_ts", j != -1 ? System.currentTimeMillis() + j : -1L);
        a().putString(key, jSONObject.toString());
    }
}
