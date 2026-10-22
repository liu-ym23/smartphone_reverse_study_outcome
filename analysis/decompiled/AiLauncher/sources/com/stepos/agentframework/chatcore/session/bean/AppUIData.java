package com.stepos.agentframework.chatcore.session.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bG\b\u0086\b\u0018\u0000 c2\u00020\u0001:\u0001dB«\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0016\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010$J\u0010\u0010'\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b'\u0010\u001cJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010$J\u0010\u0010)\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b)\u0010$J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010$J\u0012\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010$J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010$J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010$J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010$J\u0010\u00101\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b1\u0010$J\u0010\u00102\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b2\u0010$J\u0010\u00103\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b3\u0010\u001cJ\u0010\u00104\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b4\u0010\u001cJ´\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b7\u0010$J\u0010\u00108\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b8\u0010\"J\u001a\u0010:\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010$\"\u0004\b>\u0010?R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010@\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010CR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010<\u001a\u0004\bD\u0010$\"\u0004\bE\u0010?R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010F\u001a\u0004\b\b\u0010\u001c\"\u0004\bG\u0010HR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010<\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010?R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010<\u001a\u0004\bK\u0010$\"\u0004\bL\u0010?R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010<\u001a\u0004\bM\u0010$\"\u0004\bN\u0010?R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010O\u001a\u0004\bP\u0010,\"\u0004\bQ\u0010RR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010<\u001a\u0004\bS\u0010$\"\u0004\bT\u0010?R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\bU\u0010$\"\u0004\bV\u0010?R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\bW\u0010$\"\u0004\bX\u0010?R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010<\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010?R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\b[\u0010$\"\u0004\b\\\u0010?R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010<\u001a\u0004\b]\u0010$\"\u0004\b^\u0010?R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010F\u001a\u0004\b_\u0010\u001c\"\u0004\b`\u0010HR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010F\u001a\u0004\ba\u0010\u001c\"\u0004\bb\u0010H¨\u0006e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "Landroid/os/Parcelable;", "", "id", "", "uiType", "title", "", "isFixed", "appUIName", "description", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "structuredContent", "url", "html", "packageName", "widgetCls", "widgetAction", "guiAgentModelName", "holdUntilComplete", "holdAtTop", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "isReady", "()Z", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "()Ljava/lang/Object;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", ChatTracker.CLICK_COPY, "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "I", "getUiType", "setUiType", "(I)V", "getTitle", "setTitle", "Z", "setFixed", "(Z)V", "getAppUIName", "setAppUIName", "getDescription", "setDescription", "getContent", "setContent", "Ljava/lang/Object;", "getStructuredContent", "setStructuredContent", "(Ljava/lang/Object;)V", "getUrl", "setUrl", "getHtml", "setHtml", "getPackageName", "setPackageName", "getWidgetCls", "setWidgetCls", "getWidgetAction", "setWidgetAction", "getGuiAgentModelName", "setGuiAgentModelName", "getHoldUntilComplete", "setHoldUntilComplete", "getHoldAtTop", "setHoldAtTop", "Companion", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AppUIData implements Parcelable {
    private static final int TYPE_NATIVE = 0;
    private String appUIName;
    private String content;
    private String description;
    private String guiAgentModelName;
    private boolean holdAtTop;
    private boolean holdUntilComplete;
    private String html;
    private String id;
    private boolean isFixed;
    private String packageName;
    private Object structuredContent;
    private String title;
    private int uiType;
    private String url;
    private String widgetAction;
    private String widgetCls;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TYPE_WEB_HTML = 1;
    private static final int TYPE_REMOTE_VIEW = 2;
    private static final int TYPE_CUSTOM_VIEW = 3;
    private static final int TYPE_WIDGET = 4;
    private static final int TYPE_TASK_ROBIT = 5;
    public static final Parcelable.Creator<AppUIData> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/bean/AppUIData$a", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<AppUIData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppUIData createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AppUIData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppUIData[] newArray(int size) {
            return new AppUIData[size];
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/bean/AppUIData$b;", "", "<init>", "()V", "", "TYPE_NATIVE", "I", Const.INTENT_KEY_PKGNAME, "()I", "TYPE_WEB_HTML", Const.INTENT_KEY_UMID, "TYPE_CUSTOM_VIEW", Const.INTENT_KEY_APIKEY, "TYPE_WIDGET", "e", "TYPE_TASK_ROBIT", "c", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "CREATOR", "Landroid/os/Parcelable$Creator;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.bean.AppUIData$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int a() {
            return AppUIData.TYPE_CUSTOM_VIEW;
        }

        public final int b() {
            return AppUIData.TYPE_NATIVE;
        }

        public final int c() {
            return AppUIData.TYPE_TASK_ROBIT;
        }

        public final int d() {
            return AppUIData.TYPE_WEB_HTML;
        }

        public final int e() {
            return AppUIData.TYPE_WIDGET;
        }

        public Companion() {
        }
    }

    public AppUIData() {
        this(null, 0, null, false, null, null, null, null, null, null, null, null, null, null, false, false, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getHtml() {
        return this.html;
    }

    /* renamed from: component11, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getWidgetCls() {
        return this.widgetCls;
    }

    /* renamed from: component13, reason: from getter */
    public final String getWidgetAction() {
        return this.widgetAction;
    }

    /* renamed from: component14, reason: from getter */
    public final String getGuiAgentModelName() {
        return this.guiAgentModelName;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getHoldUntilComplete() {
        return this.holdUntilComplete;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getHoldAtTop() {
        return this.holdAtTop;
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
    public final String getUrl() {
        return this.url;
    }

    public final AppUIData copy(String id, int uiType, String title, boolean isFixed, String appUIName, String description, String content, Object structuredContent, String url, String html, String packageName, String widgetCls, String widgetAction, String guiAgentModelName, boolean holdUntilComplete, boolean holdAtTop) {
        p.i(id, "id");
        p.i(title, "title");
        p.i(description, "description");
        p.i(content, "content");
        p.i(url, "url");
        p.i(html, "html");
        p.i(packageName, "packageName");
        p.i(widgetCls, "widgetCls");
        p.i(widgetAction, "widgetAction");
        p.i(guiAgentModelName, "guiAgentModelName");
        return new AppUIData(id, uiType, title, isFixed, appUIName, description, content, structuredContent, url, html, packageName, widgetCls, widgetAction, guiAgentModelName, holdUntilComplete, holdAtTop);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUIData)) {
            return false;
        }
        AppUIData appUIData = (AppUIData) other;
        return p.d(this.id, appUIData.id) && this.uiType == appUIData.uiType && p.d(this.title, appUIData.title) && this.isFixed == appUIData.isFixed && p.d(this.appUIName, appUIData.appUIName) && p.d(this.description, appUIData.description) && p.d(this.content, appUIData.content) && p.d(this.structuredContent, appUIData.structuredContent) && p.d(this.url, appUIData.url) && p.d(this.html, appUIData.html) && p.d(this.packageName, appUIData.packageName) && p.d(this.widgetCls, appUIData.widgetCls) && p.d(this.widgetAction, appUIData.widgetAction) && p.d(this.guiAgentModelName, appUIData.guiAgentModelName) && this.holdUntilComplete == appUIData.holdUntilComplete && this.holdAtTop == appUIData.holdAtTop;
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

    public final String getGuiAgentModelName() {
        return this.guiAgentModelName;
    }

    public final boolean getHoldAtTop() {
        return this.holdAtTop;
    }

    public final boolean getHoldUntilComplete() {
        return this.holdUntilComplete;
    }

    public final String getHtml() {
        return this.html;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
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

    public final String getUrl() {
        return this.url;
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
        return ((((((((((((((((iHashCode2 + (obj != null ? obj.hashCode() : 0)) * 31) + this.url.hashCode()) * 31) + this.html.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.widgetCls.hashCode()) * 31) + this.widgetAction.hashCode()) * 31) + this.guiAgentModelName.hashCode()) * 31) + Boolean.hashCode(this.holdUntilComplete)) * 31) + Boolean.hashCode(this.holdAtTop);
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public final boolean isReady() {
        return this.html.length() > 0 || this.structuredContent != null;
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

    public final void setGuiAgentModelName(String str) {
        p.i(str, "<set-?>");
        this.guiAgentModelName = str;
    }

    public final void setHoldAtTop(boolean z10) {
        this.holdAtTop = z10;
    }

    public final void setHoldUntilComplete(boolean z10) {
        this.holdUntilComplete = z10;
    }

    public final void setHtml(String str) {
        p.i(str, "<set-?>");
        this.html = str;
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

    public final void setUrl(String str) {
        p.i(str, "<set-?>");
        this.url = str;
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
        return "AppUIData(id=" + this.id + ", uiType=" + this.uiType + ", title=" + this.title + ", isFixed=" + this.isFixed + ", appUIName=" + this.appUIName + ", description=" + this.description + ", content=" + this.content + ", structuredContent=" + this.structuredContent + ", url=" + this.url + ", html=" + this.html + ", packageName=" + this.packageName + ", widgetCls=" + this.widgetCls + ", widgetAction=" + this.widgetAction + ", guiAgentModelName=" + this.guiAgentModelName + ", holdUntilComplete=" + this.holdUntilComplete + ", holdAtTop=" + this.holdAtTop + ")";
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
        parcel.writeString(this.url);
        parcel.writeString(this.html);
        parcel.writeString(this.packageName);
        parcel.writeString(this.widgetCls);
        parcel.writeString(this.widgetAction);
        parcel.writeBoolean(this.holdUntilComplete);
        parcel.writeBoolean(this.holdAtTop);
    }

    public AppUIData(String id, int i10, String title, boolean z10, String str, String description, String content, Object obj, String url, String html, String packageName, String widgetCls, String widgetAction, String guiAgentModelName, boolean z11, boolean z12) {
        p.i(id, "id");
        p.i(title, "title");
        p.i(description, "description");
        p.i(content, "content");
        p.i(url, "url");
        p.i(html, "html");
        p.i(packageName, "packageName");
        p.i(widgetCls, "widgetCls");
        p.i(widgetAction, "widgetAction");
        p.i(guiAgentModelName, "guiAgentModelName");
        this.id = id;
        this.uiType = i10;
        this.title = title;
        this.isFixed = z10;
        this.appUIName = str;
        this.description = description;
        this.content = content;
        this.structuredContent = obj;
        this.url = url;
        this.html = html;
        this.packageName = packageName;
        this.widgetCls = widgetCls;
        this.widgetAction = widgetAction;
        this.guiAgentModelName = guiAgentModelName;
        this.holdUntilComplete = z11;
        this.holdAtTop = z12;
    }

    public /* synthetic */ AppUIData(String str, int i10, String str2, boolean z10, String str3, String str4, String str5, Object obj, String str6, String str7, String str8, String str9, String str10, String str11, boolean z11, boolean z12, int i11, i iVar) {
        this((i11 & 1) != 0 ? String.valueOf(System.currentTimeMillis()) : str, (i11 & 2) != 0 ? TYPE_NATIVE : i10, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? "" : str5, (i11 & 128) != 0 ? null : obj, (i11 & 256) != 0 ? "" : str6, (i11 & 512) != 0 ? "" : str7, (i11 & 1024) != 0 ? "" : str8, (i11 & 2048) != 0 ? "" : str9, (i11 & 4096) == 0 ? str10 : "", (i11 & b.THRESHOLD) != 0 ? "doubao-1.5-ui-tars" : str11, (i11 & 16384) != 0 ? false : z11, (i11 & 32768) != 0 ? false : z12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppUIData(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        int i10 = parcel.readInt();
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        boolean z10 = parcel.readBoolean();
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        String str4 = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        String str5 = string5 == null ? "" : string5;
        Object value = parcel.readValue(Object.class.getClassLoader());
        String string6 = parcel.readString();
        String str6 = string6 == null ? "" : string6;
        String string7 = parcel.readString();
        String str7 = string7 == null ? "" : string7;
        String string8 = parcel.readString();
        String str8 = string8 == null ? "" : string8;
        String string9 = parcel.readString();
        String str9 = string9 == null ? "" : string9;
        String string10 = parcel.readString();
        this(str, i10, str2, z10, str3, str4, str5, value, str6, str7, str8, str9, string10 == null ? "" : string10, null, parcel.readBoolean(), parcel.readBoolean(), b.THRESHOLD, null);
    }
}
