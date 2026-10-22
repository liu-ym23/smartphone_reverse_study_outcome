package com.stepos.agentframework.chatcore.intent;

import androidx.annotation.Keep;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001%BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJV\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\u0005\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b \u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b!\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\"\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b#\u0010\r¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;", "", "", "type", "", "isFix", "appUIName", "packageName", "widgetName", "widgetAction", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Z", "getAppUIName", "getPackageName", "getWidgetName", "getWidgetAction", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ToolAppUI {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appUIName;
    private final boolean isFix;
    private final String packageName;
    private final String type;
    private final String widgetAction;
    private final String widgetName;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/ToolAppUI$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;", "appUI", "structuredContent", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;Ljava/lang/Object;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/ToolAppUI;)I", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.intent.ToolAppUI$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(ToolAppUI appUI) {
            kotlin.jvm.internal.p.i(appUI, "appUI");
            String type = appUI.getType();
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != -1581639242) {
                    if (iHashCode != -788047292) {
                        if (iHashCode == 117588 && type.equals(p7.b.TYPE_WEB)) {
                            return AppUIData.INSTANCE.d();
                        }
                    } else if (type.equals(p7.b.TYPE_WIDGET)) {
                        return AppUIData.INSTANCE.e();
                    }
                } else if (type.equals(p7.b.TYPE_CUSTOM)) {
                    return AppUIData.INSTANCE.a();
                }
            }
            return AppUIData.INSTANCE.b();
        }

        public final AppUIData b(ToolAppUI appUI, Object structuredContent) {
            kotlin.jvm.internal.p.i(appUI, "appUI");
            int iA = a(appUI);
            String appUIName = appUI.getAppUIName();
            String packageName = appUI.getPackageName();
            String str = packageName == null ? "" : packageName;
            String widgetName = appUI.getWidgetName();
            String str2 = widgetName == null ? "" : widgetName;
            String widgetAction = appUI.getWidgetAction();
            return new AppUIData(null, iA, "title", appUI.isFix(), appUIName, "description", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, structuredContent, "", "", str, str2, widgetAction == null ? "" : widgetAction, null, false, false, 57345, null);
        }

        public Companion() {
        }
    }

    public ToolAppUI(String str, boolean z10, String str2, String str3, String str4, String str5) {
        this.type = str;
        this.isFix = z10;
        this.appUIName = str2;
        this.packageName = str3;
        this.widgetName = str4;
        this.widgetAction = str5;
    }

    public static /* synthetic */ ToolAppUI copy$default(ToolAppUI toolAppUI, String str, boolean z10, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolAppUI.type;
        }
        if ((i10 & 2) != 0) {
            z10 = toolAppUI.isFix;
        }
        if ((i10 & 4) != 0) {
            str2 = toolAppUI.appUIName;
        }
        if ((i10 & 8) != 0) {
            str3 = toolAppUI.packageName;
        }
        if ((i10 & 16) != 0) {
            str4 = toolAppUI.widgetName;
        }
        if ((i10 & 32) != 0) {
            str5 = toolAppUI.widgetAction;
        }
        String str6 = str4;
        String str7 = str5;
        return toolAppUI.copy(str, z10, str2, str3, str6, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsFix() {
        return this.isFix;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppUIName() {
        return this.appUIName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getWidgetName() {
        return this.widgetName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getWidgetAction() {
        return this.widgetAction;
    }

    public final ToolAppUI copy(String type, boolean isFix, String appUIName, String packageName, String widgetName, String widgetAction) {
        return new ToolAppUI(type, isFix, appUIName, packageName, widgetName, widgetAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolAppUI)) {
            return false;
        }
        ToolAppUI toolAppUI = (ToolAppUI) other;
        return kotlin.jvm.internal.p.d(this.type, toolAppUI.type) && this.isFix == toolAppUI.isFix && kotlin.jvm.internal.p.d(this.appUIName, toolAppUI.appUIName) && kotlin.jvm.internal.p.d(this.packageName, toolAppUI.packageName) && kotlin.jvm.internal.p.d(this.widgetName, toolAppUI.widgetName) && kotlin.jvm.internal.p.d(this.widgetAction, toolAppUI.widgetAction);
    }

    public final String getAppUIName() {
        return this.appUIName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getWidgetAction() {
        return this.widgetAction;
    }

    public final String getWidgetName() {
        return this.widgetName;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.isFix)) * 31;
        String str2 = this.appUIName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.widgetName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.widgetAction;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isFix() {
        return this.isFix;
    }

    public String toString() {
        return "ToolAppUI(type=" + this.type + ", isFix=" + this.isFix + ", appUIName=" + this.appUIName + ", packageName=" + this.packageName + ", widgetName=" + this.widgetName + ", widgetAction=" + this.widgetAction + ")";
    }

    public /* synthetic */ ToolAppUI(String str, boolean z10, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, z10, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5);
    }
}
