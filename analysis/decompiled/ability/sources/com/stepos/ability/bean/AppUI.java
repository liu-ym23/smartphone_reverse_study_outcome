package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u009d\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010 J\u0010\u0010#\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010 J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010 J\u0012\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010 J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010 J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010 J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010 J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010 J¦\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b2\u0010 J\u0010\u00103\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b3\u0010\u001eJ\u001a\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010 \"\u0004\b9\u0010:R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010>R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00107\u001a\u0004\b?\u0010 \"\u0004\b@\u0010:R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010A\u001a\u0004\b\b\u0010$\"\u0004\bB\u0010CR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00107\u001a\u0004\bD\u0010 \"\u0004\bE\u0010:R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\bF\u0010 \"\u0004\bG\u0010:R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\bH\u0010 \"\u0004\bI\u0010:R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010J\u001a\u0004\bK\u0010)\"\u0004\bL\u0010MR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\bN\u0010 R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\bO\u0010 R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\bP\u0010 R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010:R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00107\u001a\u0004\bS\u0010 \"\u0004\bT\u0010:R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00107\u001a\u0004\bU\u0010 \"\u0004\bV\u0010:¨\u0006X"}, d2 = {"Lcom/stepos/ability/bean/AppUI;", "Landroid/os/Parcelable;", "", "id", "", "uiType", "title", "", "isFixed", "appUIName", "description", "content", "", "structuredContent", "resultType", "resultSrc", "resultContent", "packageName", "widgetCls", "widgetAction", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Z", "component5", "component6", "component7", "component8", "()Ljava/lang/Object;", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/bean/AppUI;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "I", "getUiType", "setUiType", "(I)V", "getTitle", "setTitle", "Z", "setFixed", "(Z)V", "getAppUIName", "setAppUIName", "getDescription", "setDescription", "getContent", "setContent", "Ljava/lang/Object;", "getStructuredContent", "setStructuredContent", "(Ljava/lang/Object;)V", "getResultType", "getResultSrc", "getResultContent", "getPackageName", "setPackageName", "getWidgetCls", "setWidgetCls", "getWidgetAction", "setWidgetAction", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TYPE_WEB_HTML = 1;
    private static final int TYPE_REMOTE_VIEW = 2;
    private static final int TYPE_CUSTOM_VIEW = 3;
    private static final int TYPE_WIDGET = 4;
    private static final int TYPE_TASK_ROBIT = 5;
    public static final Parcelable.Creator<AppUI> CREATOR = new Parcelable.Creator<AppUI>() { // from class: com.stepos.ability.bean.AppUI$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUI createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AppUI(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUI[] newArray(int size) {
            return new AppUI[size];
        }
    };

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stepos/ability/bean/AppUI$Companion;", "", AppAgent.CONSTRUCT, "()V", "TYPE_NATIVE", "", "getTYPE_NATIVE", "()I", "TYPE_WEB_HTML", "getTYPE_WEB_HTML", "TYPE_REMOTE_VIEW", "getTYPE_REMOTE_VIEW", "TYPE_CUSTOM_VIEW", "getTYPE_CUSTOM_VIEW", "TYPE_WIDGET", "getTYPE_WIDGET", "TYPE_TASK_ROBIT", "getTYPE_TASK_ROBIT", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/AppUI;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final int getTYPE_CUSTOM_VIEW() {
            return AppUI.TYPE_CUSTOM_VIEW;
        }

        public final int getTYPE_NATIVE() {
            return AppUI.TYPE_NATIVE;
        }

        public final int getTYPE_REMOTE_VIEW() {
            return AppUI.TYPE_REMOTE_VIEW;
        }

        public final int getTYPE_TASK_ROBIT() {
            return AppUI.TYPE_TASK_ROBIT;
        }

        public final int getTYPE_WEB_HTML() {
            return AppUI.TYPE_WEB_HTML;
        }

        public final int getTYPE_WIDGET() {
            return AppUI.TYPE_WIDGET;
        }

        private Companion() {
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
        k.f(id, "id");
        k.f(title, "title");
        k.f(description, "description");
        k.f(content, "content");
        k.f(packageName, "packageName");
        k.f(widgetCls, "widgetCls");
        k.f(widgetAction, "widgetAction");
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
        return k.b(this.id, appUI.id) && this.uiType == appUI.uiType && k.b(this.title, appUI.title) && this.isFixed == appUI.isFixed && k.b(this.appUIName, appUI.appUIName) && k.b(this.description, appUI.description) && k.b(this.content, appUI.content) && k.b(this.structuredContent, appUI.structuredContent) && k.b(this.resultType, appUI.resultType) && k.b(this.resultSrc, appUI.resultSrc) && k.b(this.resultContent, appUI.resultContent) && k.b(this.packageName, appUI.packageName) && k.b(this.widgetCls, appUI.widgetCls) && k.b(this.widgetAction, appUI.widgetAction);
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
        int iD = a.d(B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.uiType, this.id.hashCode() * 31, 31), 31, this.title), 31, this.isFixed);
        String str = this.appUIName;
        int iC = B7.a.c(B7.a.c((iD + (str == null ? 0 : str.hashCode())) * 31, 31, this.description), 31, this.content);
        Object obj = this.structuredContent;
        int iHashCode = (iC + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.resultType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resultSrc;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resultContent;
        return this.widgetAction.hashCode() + B7.a.c(B7.a.c((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31, 31, this.packageName), 31, this.widgetCls);
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public final void setAppUIName(String str) {
        this.appUIName = str;
    }

    public final void setContent(String str) {
        k.f(str, "<set-?>");
        this.content = str;
    }

    public final void setDescription(String str) {
        k.f(str, "<set-?>");
        this.description = str;
    }

    public final void setFixed(boolean z10) {
        this.isFixed = z10;
    }

    public final void setId(String str) {
        k.f(str, "<set-?>");
        this.id = str;
    }

    public final void setPackageName(String str) {
        k.f(str, "<set-?>");
        this.packageName = str;
    }

    public final void setStructuredContent(Object obj) {
        this.structuredContent = obj;
    }

    public final void setTitle(String str) {
        k.f(str, "<set-?>");
        this.title = str;
    }

    public final void setUiType(int i) {
        this.uiType = i;
    }

    public final void setWidgetAction(String str) {
        k.f(str, "<set-?>");
        this.widgetAction = str;
    }

    public final void setWidgetCls(String str) {
        k.f(str, "<set-?>");
        this.widgetCls = str;
    }

    public String toString() {
        String str = this.id;
        int i = this.uiType;
        String str2 = this.title;
        boolean z10 = this.isFixed;
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
        StringBuilder sbT = a.t(i, "AppUI(id=", str, ", uiType=", ", title=");
        sbT.append(str2);
        sbT.append(", isFixed=");
        sbT.append(z10);
        sbT.append(", appUIName=");
        androidx.constraintlayout.core.dsl.a.A(sbT, str3, ", description=", str4, ", content=");
        sbT.append(str5);
        sbT.append(", structuredContent=");
        sbT.append(obj);
        sbT.append(", resultType=");
        androidx.constraintlayout.core.dsl.a.A(sbT, str6, ", resultSrc=", str7, ", resultContent=");
        androidx.constraintlayout.core.dsl.a.A(sbT, str8, ", packageName=", str9, ", widgetCls=");
        return a.p(sbT, str10, ", widgetAction=", str11, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
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

    public AppUI(String id, int i, String title, boolean z10, String str, String description, String content, Object obj, String str2, String str3, String str4, String packageName, String widgetCls, String widgetAction) {
        k.f(id, "id");
        k.f(title, "title");
        k.f(description, "description");
        k.f(content, "content");
        k.f(packageName, "packageName");
        k.f(widgetCls, "widgetCls");
        k.f(widgetAction, "widgetAction");
        this.id = id;
        this.uiType = i;
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
    public /* synthetic */ AppUI(String str, int i, String str2, boolean z10, String str3, String str4, String str5, Object obj, String str6, String str7, String str8, String str9, String str10, String str11, int i6, e eVar) {
        String string;
        if ((i6 & 1) != 0) {
            string = UUID.randomUUID().toString();
            k.e(string, "toString(...)");
        } else {
            string = str;
        }
        this(string, (i6 & 2) != 0 ? TYPE_NATIVE : i, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? false : z10, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? "" : str4, (i6 & 64) != 0 ? "" : str5, (i6 & 128) != 0 ? null : obj, (i6 & 256) != 0 ? null : str6, (i6 & 512) != 0 ? null : str7, (i6 & 1024) == 0 ? str8 : null, (i6 & 2048) != 0 ? "" : str9, (i6 & 4096) != 0 ? "" : str10, (i6 & 8192) != 0 ? "" : str11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppUI(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        int i = parcel.readInt();
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
        this(str, i, str2, z10, string3, str3, str4, value, string6, string7, string8, str5, str6, string11 == null ? "" : string11);
    }
}
