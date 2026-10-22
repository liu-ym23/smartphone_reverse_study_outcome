package com.stepos.mcp.sdk.base;

import A9.d;
import B7.a;
import B9.T;
import B9.d0;
import B9.h0;
import C7.c;
import C9.l;
import C9.x;
import com.blankj.utilcode.util.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBU\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014HÇ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 JR\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u001aJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b,\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b-\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b.\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b\t\u0010 ¨\u00062"}, d2 = {"Lcom/stepos/mcp/sdk/base/AppUI;", "", "", "type", "packageName", "appUIName", "widgetName", "widgetAction", "", "isFix", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "", "seen1", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self", "(Lcom/stepos/mcp/sdk/base/AppUI;LA9/d;Lz9/g;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Z", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/mcp/sdk/base/AppUI;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "getPackageName", "getAppUIName", "getWidgetName", "getWidgetAction", "Z", "Companion", "$serializer", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppUI {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_CUSTOM = "customView";
    public static final String TYPE_WEB = "web";
    public static final String TYPE_WIDGET = "widget";
    private final String appUIName;
    private final boolean isFix;
    private final String packageName;
    private final String type;
    private final String widgetAction;
    private final String widgetName;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/stepos/mcp/sdk/base/AppUI$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "packageName", "widgetName", "widgetAction", "Lcom/stepos/mcp/sdk/base/AppUI;", "buildWidget", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/mcp/sdk/base/AppUI;", "appUIName", "", "isFix", "buildCustomView", "(Ljava/lang/String;Ljava/lang/String;Z)Lcom/stepos/mcp/sdk/base/AppUI;", "LC9/x;", "meta", "getAppUIFromMeta", "(LC9/x;)Lcom/stepos/mcp/sdk/base/AppUI;", "Lx9/b;", "serializer", "()Lx9/b;", "TYPE_CUSTOM", "Ljava/lang/String;", "TYPE_WEB", "TYPE_WIDGET", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ AppUI buildCustomView$default(Companion companion, String str, String str2, boolean z10, int i, Object obj) {
            if ((i & 4) != 0) {
                z10 = false;
            }
            return companion.buildCustomView(str, str2, z10);
        }

        public final AppUI buildCustomView(String packageName, String appUIName, boolean isFix) {
            k.f(packageName, "packageName");
            k.f(appUIName, "appUIName");
            return new AppUI(AppUI.TYPE_CUSTOM, packageName, appUIName, (String) null, (String) null, isFix, 24, (e) null);
        }

        public final AppUI buildWidget(String packageName, String widgetName, String widgetAction) {
            k.f(packageName, "packageName");
            k.f(widgetName, "widgetName");
            k.f(widgetAction, "widgetAction");
            return new AppUI(AppUI.TYPE_WIDGET, packageName, (String) null, widgetName, widgetAction, false, 36, (e) null);
        }

        public final AppUI getAppUIFromMeta(x meta) {
            if (meta != null) {
                return (AppUI) b.a(String.valueOf((l) meta.get("appUI")), AppUI.class);
            }
            return null;
        }

        public final x9.b serializer() {
            return AppUI$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @c
    public /* synthetic */ AppUI(int i, String str, String str2, String str3, String str4, String str5, boolean z10, d0 d0Var) {
        if (3 != (i & 3)) {
            T.g(AppUI$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.type = str;
        this.packageName = str2;
        if ((i & 4) == 0) {
            this.appUIName = null;
        } else {
            this.appUIName = str3;
        }
        if ((i & 8) == 0) {
            this.widgetName = null;
        } else {
            this.widgetName = str4;
        }
        if ((i & 16) == 0) {
            this.widgetAction = null;
        } else {
            this.widgetAction = str5;
        }
        if ((i & 32) == 0) {
            this.isFix = false;
        } else {
            this.isFix = z10;
        }
    }

    public static /* synthetic */ AppUI copy$default(AppUI appUI, String str, String str2, String str3, String str4, String str5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appUI.type;
        }
        if ((i & 2) != 0) {
            str2 = appUI.packageName;
        }
        if ((i & 4) != 0) {
            str3 = appUI.appUIName;
        }
        if ((i & 8) != 0) {
            str4 = appUI.widgetName;
        }
        if ((i & 16) != 0) {
            str5 = appUI.widgetAction;
        }
        if ((i & 32) != 0) {
            z10 = appUI.isFix;
        }
        String str6 = str5;
        boolean z11 = z10;
        return appUI.copy(str, str2, str3, str4, str6, z11);
    }

    public static final /* synthetic */ void write$Self(AppUI self, d output, g serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.packageName);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appUIName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.appUIName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.widgetName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, h0.f242a, self.widgetName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.widgetAction != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, h0.f242a, self.widgetAction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isFix) {
            output.encodeBooleanElement(serialDesc, 5, self.isFix);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppUIName() {
        return this.appUIName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getWidgetName() {
        return this.widgetName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getWidgetAction() {
        return this.widgetAction;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsFix() {
        return this.isFix;
    }

    public final AppUI copy(String type, String packageName, String appUIName, String widgetName, String widgetAction, boolean isFix) {
        k.f(type, "type");
        k.f(packageName, "packageName");
        return new AppUI(type, packageName, appUIName, widgetName, widgetAction, isFix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUI)) {
            return false;
        }
        AppUI appUI = (AppUI) other;
        return k.b(this.type, appUI.type) && k.b(this.packageName, appUI.packageName) && k.b(this.appUIName, appUI.appUIName) && k.b(this.widgetName, appUI.widgetName) && k.b(this.widgetAction, appUI.widgetAction) && this.isFix == appUI.isFix;
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iC = a.c(this.type.hashCode() * 31, 31, this.packageName);
        String str = this.appUIName;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.widgetName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.widgetAction;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z10 = this.isFix;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public final boolean isFix() {
        return this.isFix;
    }

    public String toString() {
        String str = this.type;
        String str2 = this.packageName;
        String str3 = this.appUIName;
        String str4 = this.widgetName;
        String str5 = this.widgetAction;
        boolean z10 = this.isFix;
        StringBuilder sbW = a.w("AppUI(type=", str, ", packageName=", str2, ", appUIName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", widgetName=", str4, ", widgetAction=");
        sbW.append(str5);
        sbW.append(", isFix=");
        sbW.append(z10);
        sbW.append(")");
        return sbW.toString();
    }

    public AppUI(String type, String packageName, String str, String str2, String str3, boolean z10) {
        k.f(type, "type");
        k.f(packageName, "packageName");
        this.type = type;
        this.packageName = packageName;
        this.appUIName = str;
        this.widgetName = str2;
        this.widgetAction = str3;
        this.isFix = z10;
    }

    public /* synthetic */ AppUI(String str, String str2, String str3, String str4, String str5, boolean z10, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? false : z10);
    }
}
