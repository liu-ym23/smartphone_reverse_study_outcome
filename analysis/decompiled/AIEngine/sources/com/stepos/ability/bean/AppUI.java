package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import h0.e;
import java.util.UUID;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppUI implements Parcelable {
    private static final int TYPE_CUSTOM_VIEW = 3;
    private static final int TYPE_NATIVE = 0;
    private static final int TYPE_REMOTE_VIEW = 2;
    private static final int TYPE_TASK_ROBIT = 5;
    private static final int TYPE_WEB_HTML = 1;
    private static final int TYPE_WIDGET = 4;
    private String appUIName;
    private String content;
    private String description;

    /* renamed from: id, reason: collision with root package name */
    private String f5557id;
    private boolean isFixed;
    private String packageName;
    private final String resultContent;
    private final String resultSrc;
    private final String resultType;
    private Object structuredContent;
    private String title;
    private int uiType;
    private String widgetAction;
    private String widgetCls;
    public static final b Companion = new b();
    public static final Parcelable.Creator<AppUI> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<AppUI> {
        @Override // android.os.Parcelable.Creator
        public final AppUI createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AppUI(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AppUI[] newArray(int i10) {
            return new AppUI[i10];
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public AppUI() {
        this(null, 0, null, false, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public final String component1() {
        return this.f5557id;
    }

    public final String component10() {
        return this.resultSrc;
    }

    public final String component11() {
        return this.resultContent;
    }

    public final String component12() {
        return this.packageName;
    }

    public final String component13() {
        return this.widgetCls;
    }

    public final String component14() {
        return this.widgetAction;
    }

    public final int component2() {
        return this.uiType;
    }

    public final String component3() {
        return this.title;
    }

    public final boolean component4() {
        return this.isFixed;
    }

    public final String component5() {
        return this.appUIName;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.content;
    }

    public final Object component8() {
        return this.structuredContent;
    }

    public final String component9() {
        return this.resultType;
    }

    public final AppUI copy(String id2, int i10, String title, boolean z, String str, String description, String content, Object obj, String str2, String str3, String str4, String packageName, String widgetCls, String widgetAction) {
        g.f(id2, "id");
        g.f(title, "title");
        g.f(description, "description");
        g.f(content, "content");
        g.f(packageName, "packageName");
        g.f(widgetCls, "widgetCls");
        g.f(widgetAction, "widgetAction");
        return new AppUI(id2, i10, title, z, str, description, content, obj, str2, str3, str4, packageName, widgetCls, widgetAction);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUI)) {
            return false;
        }
        AppUI appUI = (AppUI) obj;
        return g.b(this.f5557id, appUI.f5557id) && this.uiType == appUI.uiType && g.b(this.title, appUI.title) && this.isFixed == appUI.isFixed && g.b(this.appUIName, appUI.appUIName) && g.b(this.description, appUI.description) && g.b(this.content, appUI.content) && g.b(this.structuredContent, appUI.structuredContent) && g.b(this.resultType, appUI.resultType) && g.b(this.resultSrc, appUI.resultSrc) && g.b(this.resultContent, appUI.resultContent) && g.b(this.packageName, appUI.packageName) && g.b(this.widgetCls, appUI.widgetCls) && g.b(this.widgetAction, appUI.widgetAction);
    }

    public final String getAppUIName() {
        return this.appUIName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f5557id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getResultContent() {
        return this.resultContent;
    }

    public final String getResultSrc() {
        return this.resultSrc;
    }

    public final String getResultType() {
        return this.resultType;
    }

    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final String getWidgetAction() {
        return this.widgetAction;
    }

    public final String getWidgetCls() {
        return this.widgetCls;
    }

    public int hashCode() {
        int iF = ai.onnxruntime.a.f(d.a(ai.onnxruntime.a.d(this.uiType, this.f5557id.hashCode() * 31, 31), 31, this.title), 31, this.isFixed);
        String str = this.appUIName;
        int iA = d.a(d.a((iF + (str == null ? 0 : str.hashCode())) * 31, 31, this.description), 31, this.content);
        Object obj = this.structuredContent;
        int iHashCode = (iA + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.resultType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resultSrc;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resultContent;
        return this.widgetAction.hashCode() + d.a(d.a((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31, 31, this.packageName), 31, this.widgetCls);
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public final void setAppUIName(String str) {
        this.appUIName = str;
    }

    public final void setContent(String str) {
        g.f(str, "<set-?>");
        this.content = str;
    }

    public final void setDescription(String str) {
        g.f(str, "<set-?>");
        this.description = str;
    }

    public final void setFixed(boolean z) {
        this.isFixed = z;
    }

    public final void setId(String str) {
        g.f(str, "<set-?>");
        this.f5557id = str;
    }

    public final void setPackageName(String str) {
        g.f(str, "<set-?>");
        this.packageName = str;
    }

    public final void setStructuredContent(Object obj) {
        this.structuredContent = obj;
    }

    public final void setTitle(String str) {
        g.f(str, "<set-?>");
        this.title = str;
    }

    public final void setUiType(int i10) {
        this.uiType = i10;
    }

    public final void setWidgetAction(String str) {
        g.f(str, "<set-?>");
        this.widgetAction = str;
    }

    public final void setWidgetCls(String str) {
        g.f(str, "<set-?>");
        this.widgetCls = str;
    }

    public String toString() {
        String str = this.f5557id;
        int i10 = this.uiType;
        String str2 = this.title;
        boolean z = this.isFixed;
        String str3 = this.appUIName;
        String str4 = this.description;
        String str5 = this.content;
        Object obj = this.structuredContent;
        String str6 = this.resultType;
        String str7 = this.resultSrc;
        String str8 = this.resultContent;
        String str9 = this.packageName;
        String str10 = this.widgetCls;
        String str11 = this.widgetAction;
        StringBuilder sbF = e.f("AppUI(id=", str, ", uiType=", i10, ", title=");
        sbF.append(str2);
        sbF.append(", isFixed=");
        sbF.append(z);
        sbF.append(", appUIName=");
        ai.onnxruntime.a.z(sbF, str3, ", description=", str4, ", content=");
        sbF.append(str5);
        sbF.append(", structuredContent=");
        sbF.append(obj);
        sbF.append(", resultType=");
        ai.onnxruntime.a.z(sbF, str6, ", resultSrc=", str7, ", resultContent=");
        ai.onnxruntime.a.z(sbF, str8, ", packageName=", str9, ", widgetCls=");
        return com.stepos.core.ota.d.j(sbF, str10, ", widgetAction=", str11, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        parcel.writeString(this.f5557id);
        parcel.writeInt(this.uiType);
        parcel.writeString(this.title);
        parcel.writeBoolean(this.isFixed);
        parcel.writeString(this.appUIName);
        parcel.writeString(this.description);
        parcel.writeString(this.content);
        parcel.writeValue(this.structuredContent);
        parcel.writeString(this.resultType);
        parcel.writeString(this.resultSrc);
        parcel.writeString(this.resultContent);
        parcel.writeString(this.packageName);
        parcel.writeString(this.widgetCls);
        parcel.writeString(this.widgetAction);
    }

    public AppUI(String id2, int i10, String title, boolean z, String str, String description, String content, Object obj, String str2, String str3, String str4, String packageName, String widgetCls, String widgetAction) {
        g.f(id2, "id");
        g.f(title, "title");
        g.f(description, "description");
        g.f(content, "content");
        g.f(packageName, "packageName");
        g.f(widgetCls, "widgetCls");
        g.f(widgetAction, "widgetAction");
        this.f5557id = id2;
        this.uiType = i10;
        this.title = title;
        this.isFixed = z;
        this.appUIName = str;
        this.description = description;
        this.content = content;
        this.structuredContent = obj;
        this.resultType = str2;
        this.resultSrc = str3;
        this.resultContent = str4;
        this.packageName = packageName;
        this.widgetCls = widgetCls;
        this.widgetAction = widgetAction;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AppUI(String str, int i10, String str2, boolean z, String str3, String str4, String str5, Object obj, String str6, String str7, String str8, String str9, String str10, String str11, int i11, kotlin.jvm.internal.e eVar) {
        String string;
        if ((i11 & 1) != 0) {
            string = UUID.randomUUID().toString();
            g.e(string, "toString(...)");
        } else {
            string = str;
        }
        this(string, (i11 & 2) != 0 ? TYPE_NATIVE : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? false : z, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? "" : str5, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? null : obj, (i11 & 256) != 0 ? null : str6, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? null : str7, (i11 & 1024) == 0 ? str8 : null, (i11 & 2048) != 0 ? "" : str9, (i11 & 4096) != 0 ? "" : str10, (i11 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? "" : str11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppUI(Parcel parcel) {
        g.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        int i10 = parcel.readInt();
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        boolean z = parcel.readBoolean();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String str3 = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        String str4 = string5 == null ? "" : string5;
        Object value = parcel.readValue(Object.class.getClassLoader());
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        String str5 = string9 == null ? "" : string9;
        String string10 = parcel.readString();
        String str6 = string10 == null ? "" : string10;
        String string11 = parcel.readString();
        this(str, i10, str2, z, string3, str3, str4, value, string6, string7, string8, str5, str6, string11 == null ? "" : string11);
    }
}
