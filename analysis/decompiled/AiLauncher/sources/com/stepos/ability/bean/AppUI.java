package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001XB\u009d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u0010\u0010#\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010 J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010 J\u0012\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010 J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010 J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010 J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010 J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010 J¦\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b2\u0010 J\u0010\u00103\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b3\u0010\u001eJ\u001a\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010 \"\u0004\b9\u0010:R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010>R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00107\u001a\u0004\b?\u0010 \"\u0004\b@\u0010:R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010A\u001a\u0004\b\b\u0010$\"\u0004\bB\u0010CR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00107\u001a\u0004\bD\u0010 \"\u0004\bE\u0010:R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\bF\u0010 \"\u0004\bG\u0010:R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\bH\u0010 \"\u0004\bI\u0010:R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010J\u001a\u0004\bK\u0010)\"\u0004\bL\u0010MR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\bN\u0010 R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\bO\u0010 R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\bP\u0010 R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010:R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00107\u001a\u0004\bS\u0010 \"\u0004\bT\u0010:R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00107\u001a\u0004\bU\u0010 \"\u0004\bV\u0010:¨\u0006Y"}, d2 = {"Lcom/stepos/ability/bean/AppUI;", "Landroid/os/Parcelable;", "", "id", "", "uiType", "title", "", "isFixed", "appUIName", "description", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "structuredContent", "resultType", "resultSrc", "resultContent", "packageName", "widgetCls", "widgetAction", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Z", "component5", "component6", "component7", "component8", "()Ljava/lang/Object;", "component9", "component10", "component11", "component12", "component13", "component14", ChatTracker.CLICK_COPY, "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/bean/AppUI;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "I", "getUiType", "setUiType", "(I)V", "getTitle", "setTitle", "Z", "setFixed", "(Z)V", "getAppUIName", "setAppUIName", "getDescription", "setDescription", "getContent", "setContent", "Ljava/lang/Object;", "getStructuredContent", "setStructuredContent", "(Ljava/lang/Object;)V", "getResultType", "getResultSrc", "getResultContent", "getPackageName", "setPackageName", "getWidgetCls", "setWidgetCls", "getWidgetAction", "setWidgetAction", "Companion", Const.INTENT_KEY_PKGNAME, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AppUI implements Parcelable {
    private static final int TYPE_NATIVE = 0;
    private String appUIName;
    private String content;
    private String description;
    private String id;
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
    private static final int TYPE_WEB_HTML = 1;
    private static final int TYPE_REMOTE_VIEW = 2;
    private static final int TYPE_CUSTOM_VIEW = 3;
    private static final int TYPE_WIDGET = 4;
    private static final int TYPE_TASK_ROBIT = 5;
    public static final Parcelable.Creator<AppUI> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ability/bean/AppUI$a", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/AppUI;", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/ability/bean/AppUI;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/ability/bean/AppUI;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AppUI> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppUI createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AppUI(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppUI[] newArray(int size) {
            return new AppUI[size];
        }
    }

    public AppUI() {
        this(null, 0, null, false, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getResultSrc() {
        return this.resultSrc;
    }

    /* renamed from: component11, reason: from getter */
    public final String getResultContent() {
        return this.resultContent;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component13, reason: from getter */
    public final String getWidgetCls() {
        return this.widgetCls;
    }

    /* renamed from: component14, reason: from getter */
    public final String getWidgetAction() {
        return this.widgetAction;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUiType() {
        return this.uiType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFixed() {
        return this.isFixed;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppUIName() {
        return this.appUIName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component8, reason: from getter */
    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    /* renamed from: component9, reason: from getter */
    public final String getResultType() {
        return this.resultType;
    }

    public final AppUI copy(String id, int uiType, String title, boolean isFixed, String appUIName, String description, String content, Object structuredContent, String resultType, String resultSrc, String resultContent, String packageName, String widgetCls, String widgetAction) {
        p.i(id, "id");
        p.i(title, "title");
        p.i(description, "description");
        p.i(content, "content");
        p.i(packageName, "packageName");
        p.i(widgetCls, "widgetCls");
        p.i(widgetAction, "widgetAction");
        return new AppUI(id, uiType, title, isFixed, appUIName, description, content, structuredContent, resultType, resultSrc, resultContent, packageName, widgetCls, widgetAction);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUI)) {
            return false;
        }
        AppUI appUI = (AppUI) other;
        return p.d(this.id, appUI.id) && this.uiType == appUI.uiType && p.d(this.title, appUI.title) && this.isFixed == appUI.isFixed && p.d(this.appUIName, appUI.appUIName) && p.d(this.description, appUI.description) && p.d(this.content, appUI.content) && p.d(this.structuredContent, appUI.structuredContent) && p.d(this.resultType, appUI.resultType) && p.d(this.resultSrc, appUI.resultSrc) && p.d(this.resultContent, appUI.resultContent) && p.d(this.packageName, appUI.packageName) && p.d(this.widgetCls, appUI.widgetCls) && p.d(this.widgetAction, appUI.widgetAction);
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
        return this.id;
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
        int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.uiType)) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isFixed)) * 31;
        String str = this.appUIName;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.description.hashCode()) * 31) + this.content.hashCode()) * 31;
        Object obj = this.structuredContent;
        int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.resultType;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resultSrc;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resultContent;
        return ((((((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.packageName.hashCode()) * 31) + this.widgetCls.hashCode()) * 31) + this.widgetAction.hashCode();
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public final void setAppUIName(String str) {
        this.appUIName = str;
    }

    public final void setContent(String str) {
        p.i(str, "<set-?>");
        this.content = str;
    }

    public final void setDescription(String str) {
        p.i(str, "<set-?>");
        this.description = str;
    }

    public final void setFixed(boolean z10) {
        this.isFixed = z10;
    }

    public final void setId(String str) {
        p.i(str, "<set-?>");
        this.id = str;
    }

    public final void setPackageName(String str) {
        p.i(str, "<set-?>");
        this.packageName = str;
    }

    public final void setStructuredContent(Object obj) {
        this.structuredContent = obj;
    }

    public final void setTitle(String str) {
        p.i(str, "<set-?>");
        this.title = str;
    }

    public final void setUiType(int i10) {
        this.uiType = i10;
    }

    public final void setWidgetAction(String str) {
        p.i(str, "<set-?>");
        this.widgetAction = str;
    }

    public final void setWidgetCls(String str) {
        p.i(str, "<set-?>");
        this.widgetCls = str;
    }

    public String toString() {
        return "AppUI(id=" + this.id + ", uiType=" + this.uiType + ", title=" + this.title + ", isFixed=" + this.isFixed + ", appUIName=" + this.appUIName + ", description=" + this.description + ", content=" + this.content + ", structuredContent=" + this.structuredContent + ", resultType=" + this.resultType + ", resultSrc=" + this.resultSrc + ", resultContent=" + this.resultContent + ", packageName=" + this.packageName + ", widgetCls=" + this.widgetCls + ", widgetAction=" + this.widgetAction + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.id);
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

    public AppUI(String id, int i10, String title, boolean z10, String str, String description, String content, Object obj, String str2, String str3, String str4, String packageName, String widgetCls, String widgetAction) {
        p.i(id, "id");
        p.i(title, "title");
        p.i(description, "description");
        p.i(content, "content");
        p.i(packageName, "packageName");
        p.i(widgetCls, "widgetCls");
        p.i(widgetAction, "widgetAction");
        this.id = id;
        this.uiType = i10;
        this.title = title;
        this.isFixed = z10;
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
    public /* synthetic */ AppUI(String str, int i10, String str2, boolean z10, String str3, String str4, String str5, Object obj, String str6, String str7, String str8, String str9, String str10, String str11, int i11, i iVar) {
        String string;
        if ((i11 & 1) != 0) {
            string = UUID.randomUUID().toString();
            p.h(string, "toString(...)");
        } else {
            string = str;
        }
        this(string, (i11 & 2) != 0 ? TYPE_NATIVE : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? "" : str5, (i11 & 128) != 0 ? null : obj, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : str7, (i11 & 1024) == 0 ? str8 : null, (i11 & 2048) != 0 ? "" : str9, (i11 & 4096) != 0 ? "" : str10, (i11 & b.THRESHOLD) != 0 ? "" : str11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppUI(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        int i10 = parcel.readInt();
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        boolean z10 = parcel.readBoolean();
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
        this(str, i10, str2, z10, string3, str3, str4, value, string6, string7, string8, str5, str6, string11 == null ? "" : string11);
    }
}
