package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FeatureConfigMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureConfigMap implements Parcelable {
    public static final Parcelable.Creator<FeatureConfigMap> CREATOR = null;

    @SerializedName("config_map")
    private Map<String, FeatureConfigBean> configMap;

    /* JADX INFO: compiled from: FeatureConfigMap.kt */
    public static final class Creator implements Parcelable.Creator<FeatureConfigMap> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfigMap createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            int r4 = r5.readInt();
            LinkedHashMap r0 = new LinkedHashMap(r4);
            int r1 = 0;
        L3:
            if (r1 == r4) goto L10;
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L7;
            FeatureConfigBean r3 = null;
        L8:
            r0.put(r2, r3);
            r1 = r1 + 1;
            goto L3
        L7:
            r3 = FeatureConfigBean.CREATOR.createFromParcel(r5);
            goto L8
        L10:
            return new FeatureConfigMap((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfigMap createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfigMap[] newArray(int r1) {
            return new FeatureConfigMap[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfigMap[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureConfigMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FeatureConfigMap copy$default(FeatureConfigMap r1, Map r2, int r3, Object r4) {
        Map<String, FeatureConfigBean> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.configMap;
    L6:
        return r1.copy(r5);
    }

    public final Map<String, FeatureConfigBean> component1() {
        return this.configMap;
    }

    public final FeatureConfigMap copy(Map<String, FeatureConfigBean> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "configMap");
        return new FeatureConfigMap(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureConfigMap.class) == true) goto L8;
        return false;
    L8:
        FeatureConfigMap r6 = (FeatureConfigMap) ZeusTransformUtils.preCheckCast(r5, FeatureConfigMap.class, "com.obric.aiagent.plugin");
        if (o.a(this.configMap, r6.configMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.configMap.hashCode();
    }

    public String toString() {
        return "FeatureConfigMap(configMap=" + this.configMap + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        Map<String, FeatureConfigBean> r4 = this.configMap;
        r5.writeInt(r4.size());
        Iterator<Map.Entry<String, FeatureConfigBean>> r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry<String, FeatureConfigBean> r0 = r7.next();
        r5.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        FeatureConfigBean r1 = (FeatureConfigBean) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), FeatureConfigBean.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        r5.writeInt(1);
        r1.writeToParcel(r5, r6);
        goto L4
    L7:
        r5.writeInt(0);
        goto L4
    }

    public FeatureConfigMap(Map<String, FeatureConfigBean> r3) {
        Map<String, FeatureConfigBean> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "configMap");
        this.configMap = r4;
    }

    public final Map<String, FeatureConfigBean> getConfigMap() {
        return this.configMap;
    }

    public final void setConfigMap(Map<String, FeatureConfigBean> r3) {
        Map<String, FeatureConfigBean> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.configMap = r4;
    }

    public /* synthetic */ FeatureConfigMap(Map r2, int r3, h r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L5:
        this(r5);
    }
}
