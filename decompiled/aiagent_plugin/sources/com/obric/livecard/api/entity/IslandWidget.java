package com.obric.livecard.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IslandSessionEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandWidget implements Parcelable {
    public static final CREATOR CREATOR = null;
    private JsonObject ext;
    private List<? extends TransitionAnimation> inAnimation;
    private final Boolean isDefault;
    private a<x> onCardClickCallback;
    private Map<String, a<x>> onClickCallback;
    private List<? extends TransitionAnimation> outAnimation;
    private Object templateData;
    private final String templateId;
    private View view;

    /* JADX INFO: compiled from: IslandSessionEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<IslandWidget> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new IslandWidget(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget[] newArray(int r1) {
            return new IslandWidget[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ IslandWidget copy$default(IslandWidget r12, String r13, Object r14, Boolean r15, View r16, List r17, List r18, JsonObject r19, Map r20, a r21, int r22, Object r23) {
        List<? extends TransitionAnimation> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List<? extends TransitionAnimation> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Map<String, a<x>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        a<x> r3 = (a) ZeusTransformUtils.wrapperContextForParams(r21, a.class, "com.obric.aiagent.plugin");
        if ((r22 & 1) == 0) goto L5;
        String r6 = r12.templateId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Object r7 = r12.templateData;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Boolean r8 = r12.isDefault;
    L15:
        if ((r22 & 8) == 0) goto L17;
        View r9 = r12.view;
    L19:
        if ((r22 & 16) == 0) goto L22;
        r2 = r12.inAnimation;
    L22:
        if ((r22 & 32) == 0) goto L25;
        r4 = r12.outAnimation;
    L25:
        if ((r22 & 64) == 0) goto L27;
        JsonObject r10 = r12.ext;
    L29:
        if ((r22 & 128) == 0) goto L32;
        r5 = r12.onClickCallback;
    L32:
        if ((r22 & 256) == 0) goto L34;
        a<x> r1 = r12.onCardClickCallback;
    L36:
        return r12.copy(r6, r7, r8, r9, r2, r4, r10, r5, r1);
    L34:
        r1 = r3;
        goto L36
    L27:
        r10 = r19;
        goto L29
    L17:
        r9 = r16;
        goto L19
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    public final String component1() {
        return this.templateId;
    }

    public final Object component2() {
        return this.templateData;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final View component4() {
        return this.view;
    }

    public final List<TransitionAnimation> component5() {
        return this.inAnimation;
    }

    public final List<TransitionAnimation> component6() {
        return this.outAnimation;
    }

    public final JsonObject component7() {
        return this.ext;
    }

    public final Map<String, a<x>> component8() {
        return this.onClickCallback;
    }

    public final a<x> component9() {
        return this.onCardClickCallback;
    }

    public final IslandWidget copy(String r13, Object r14, Boolean r15, View r16, List<? extends TransitionAnimation> r17, List<? extends TransitionAnimation> r18, JsonObject r19, Map<String, a<x>> r20, a<x> r21) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r21, a.class, "com.obric.aiagent.plugin");
        o.e(r13, "templateId");
        o.e(r14, "templateData");
        o.e(r10, "onClickCallback");
        return new IslandWidget(r13, r14, r15, r16, r7, r8, r19, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IslandWidget.class) == true) goto L8;
        return false;
    L8:
        IslandWidget r6 = (IslandWidget) ZeusTransformUtils.preCheckCast(r5, IslandWidget.class, "com.obric.aiagent.plugin");
        if (o.a(this.templateId, r6.templateId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.templateData, r6.templateData) == true) goto L15;
        return false;
    L15:
        if (o.a(this.isDefault, r6.isDefault) == true) goto L18;
        return false;
    L18:
        if (o.a(this.view, r6.view) == true) goto L21;
        return false;
    L21:
        if (o.a(this.inAnimation, r6.inAnimation) == true) goto L24;
        return false;
    L24:
        if (o.a(this.outAnimation, r6.outAnimation) == true) goto L27;
        return false;
    L27:
        if (o.a(this.ext, r6.ext) == true) goto L30;
        return false;
    L30:
        if (o.a(this.onClickCallback, r6.onClickCallback) == true) goto L33;
        return false;
    L33:
        if (o.a(this.onCardClickCallback, r6.onCardClickCallback) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.templateId.hashCode() * 31) + this.templateData.hashCode()) * 31;
        Boolean r1 = this.isDefault;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        View r5 = this.view;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<? extends TransitionAnimation> r8 = this.inAnimation;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<? extends TransitionAnimation> r11 = this.outAnimation;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        JsonObject r14 = this.ext;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + this.onClickCallback.hashCode()) * 31;
        a<x> r17 = this.onCardClickCallback;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public IslandWidget(String r3, Object r4, Boolean r5, View r6, List<? extends TransitionAnimation> r7, List<? extends TransitionAnimation> r8, JsonObject r9, Map<String, a<x>> r10, a<x> r11) {
        List<? extends TransitionAnimation> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<? extends TransitionAnimation> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Map<String, a<x>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        a<x> r15 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "templateId");
        o.e(r4, "templateData");
        o.e(r14, "onClickCallback");
        this.templateId = r3;
        this.templateData = r4;
        this.isDefault = r5;
        this.view = r6;
        this.inAnimation = r12;
        this.outAnimation = r13;
        this.ext = r9;
        this.onClickCallback = r14;
        this.onCardClickCallback = r15;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Object getTemplateData() {
        return this.templateData;
    }

    public final void setTemplateData(Object r2) {
        o.e(r2, "<set-?>");
        this.templateData = r2;
    }

    public /* synthetic */ IslandWidget(String r18, Object r19, Boolean r20, View r21, List r22, List r23, JsonObject r24, Map r25, a r26, int r27, h r28) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r26, a.class, "com.obric.aiagent.plugin");
        if ((r27 & 4) == 0) goto L5;
        Boolean r10 = false;
    L7:
        if ((r27 & 8) == 0) goto L9;
        View r11 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        List r12 = null;
    L15:
        if ((r27 & 32) == 0) goto L17;
        List r13 = null;
    L19:
        if ((r27 & 64) == 0) goto L21;
        JsonObject r14 = null;
    L23:
        if ((r27 & 128) == 0) goto L25;
        r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    L25:
        Map r15 = r4;
        if ((r27 & 256) == 0) goto L28;
        a r16 = null;
    L29:
        this(r18, r19, r10, r11, r12, r13, r14, r15, r16);
        return;
    L28:
        r16 = r5;
        goto L29
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r3;
        goto L19
    L13:
        r12 = r1;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView(View r1) {
        this.view = r1;
    }

    public final List<TransitionAnimation> getInAnimation() {
        return this.inAnimation;
    }

    public final void setInAnimation(List<? extends TransitionAnimation> r3) {
        this.inAnimation = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<TransitionAnimation> getOutAnimation() {
        return this.outAnimation;
    }

    public final void setOutAnimation(List<? extends TransitionAnimation> r3) {
        this.outAnimation = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final void setExt(JsonObject r1) {
        this.ext = r1;
    }

    public final Map<String, a<x>> getOnClickCallback() {
        return this.onClickCallback;
    }

    public final void setOnClickCallback(Map<String, a<x>> r3) {
        Map<String, a<x>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.onClickCallback = r4;
    }

    public final a<x> getOnCardClickCallback() {
        return this.onCardClickCallback;
    }

    public final void setOnCardClickCallback(a<x> r3) {
        this.onCardClickCallback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public IslandWidget(Parcel r15) {
        o.e(r15, "parcel");
        String r0 = r15.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = r15.readString();
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        Object r2 = r15.readValue(Boolean.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L13;
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");
    L14:
        Void r6 = (Void) ZeusTransformUtils.preCheckCast(null, Void.class, "com.obric.aiagent.plugin");
        Object r7 = r15.readValue(Integer.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin");
    L17:
        Object r9 = r15.readValue(Integer.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L20;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.aiagent.plugin");
    L20:
        x r11 = x.f38692a;
        View r12 = (View) ZeusTransformUtils.preCheckCast(null, View.class, "com.obric.aiagent.plugin");
        String r13 = r15.readString();
        if (r13 == null) goto L33;
        List r14 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r13, new IslandWidget$2$1().getType()), List.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L31;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L26:
        if (r18.hasNext() == false) goto L30;
        TransitionAnimation r19 = TransitionAnimation.Companion.fromString((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin"));
        if (r19 == null) goto L26;
        r17.add(r19);
        goto L26
    L30:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
    L32:
        List r21 = r20;
    L34:
        String r22 = r15.readString();
        if (r22 == null) goto L47;
        List r23 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r22, new IslandWidget$3$1().getType()), List.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L45;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r24.iterator();
    L40:
        if (r26.hasNext() == false) goto L44;
        TransitionAnimation r27 = TransitionAnimation.Companion.fromString((String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.aiagent.plugin"));
        if (r27 == null) goto L40;
        r25.add(r27);
        goto L40
    L44:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin");
    L46:
        List r29 = r28;
    L48:
        String r110 = r15.readString();
        if (r110 == null) goto L51;
        JsonObject r30 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r110, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L52:
        this(r3, r4, r5, r12, r21, r29, r30, null, null, 384, null);
        return;
    L51:
        r30 = null;
        goto L52
    L45:
        r28 = null;
        goto L46
    L47:
        r29 = null;
        goto L48
    L31:
        r20 = null;
        goto L32
    L33:
        r21 = null;
        goto L34
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public final void addOnViewClickCallback(String r3, a<x> r4) {
        a<x> r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r3, "viewId");
        o.e(r5, "onClick");
        this.onClickCallback.put(r3, r5);
    }

    public final a<x> findOnViewClickCallbackById(String r2) {
        o.e(r2, "viewId");
        return (a) ZeusTransformUtils.preCheckCast(this.onClickCallback.get(r2), a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "parcel");
        r4.writeString(this.templateId);
        Object r6 = this.templateData;
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L5;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L6:
        if (r7 == null) goto L8;
        r4.writeString(r7);
        x r8 = x.f38692a;
    L9:
        if (r8 != null) goto L11;
        r4.writeString(new Gson().toJson(this.templateData));
    L11:
        r4.writeValue(this.isDefault);
        r4.writeValue(null);
        r4.writeValue(null);
        r4.writeString(new Gson().toJson(this.inAnimation));
        r4.writeString(new Gson().toJson(this.outAnimation));
        JsonObject r3 = this.ext;
        if (r3 == null) goto L14;
        r2 = new Gson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"));
    L14:
        r4.writeString(r2);
        return;
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public String toString() {
        return "IslandWidget(isDefault=" + this.isDefault + ", templateData=" + this.templateData + ", templateId='" + this.templateId + "', ext=" + this.ext + ", inAnimation=" + this.inAnimation + ", outAnimation=" + this.outAnimation + ')';
    }
}
