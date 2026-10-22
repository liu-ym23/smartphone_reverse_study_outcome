package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.utils.f;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.gift.model.n;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t2.c;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001b\u0010\u001fJ6\u0010x\u001a\u00020y2$\u0010z\u001a \u0012\u0006\u0012\u0004\u0018\u00010|\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020y0{j\u0002`}2\b\b\u0002\u0010~\u001a\u00020]J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u007f\u001a\u00020\u0003H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020y2\u0007\u0010\u0086\u0001\u001a\u00020\u001e2\b\u0010\u0087\u0001\u001a\u00030\u0084\u0001H\u0016J\u0014\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00142\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010*R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010*R$\u00101\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010!\"\u0004\b5\u0010*R8\u00106\u001a\u0016\u0012\u0004\u0012\u000208\u0018\u000107j\n\u0012\u0004\u0012\u000208\u0018\u0001`98\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u00103\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u00103\u001a\u0004\bA\u0010!\"\u0004\bB\u0010*R$\u0010C\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u00103\u001a\u0004\bE\u0010!\"\u0004\bF\u0010*R$\u0010G\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bH\u00103\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010*R \u0010K\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010#\"\u0004\bT\u0010%R,\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020W\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020]8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010!\"\u0004\bd\u0010*R \u0010e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010!\"\u0004\bg\u0010*R \u0010h\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010o8G¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0011\u0010r\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\bs\u0010!R\u001b\u0010t\u001a\u00020\u00038BX\u0083\u0084\u0002¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bu\u0010!¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/ai/model/objects/Applet;", "Lcom/bytedance/ai/model/objects/AIPackage;", "name", "", "packageName", RuleConditionBean.VERSION_CODE_KEY, "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", "recommend", "keywords", "", "appGroup", IFlowAppIntentIDL.PARAM_APPLET_ID, "pages", "Lcom/bytedance/ai/model/objects/Page;", n.KEY_PLUGINS, "Lcom/bytedance/ai/model/objects/Plugin;", "botId", "appletEntry", "appRuntimeEntry", "runtimeVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAppletId", "()Ljava/lang/String;", "getPages", "()Ljava/util/List;", "setPages", "(Ljava/util/List;)V", "getPlugins", "setPlugins", "getBotId", "setBotId", "(Ljava/lang/String;)V", "getAppletEntry", "setAppletEntry", "getAppRuntimeEntry", "botDevMode", "getBotDevMode", "setBotDevMode", "version", "getVersion$annotations", "()V", "getVersion", "setVersion", "widgets", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Widget;", "Lkotlin/collections/ArrayList;", "getWidgets$annotations", "getWidgets", "()Ljava/util/ArrayList;", "setWidgets", "(Ljava/util/ArrayList;)V", "entry", "getEntry$annotations", "getEntry", "setEntry", "appletDirName", "getAppletDirName$annotations", "getAppletDirName", "setAppletDirName", "channelName", "getChannelName$annotations", "getChannelName", "setChannelName", "mainInit", "Lcom/bytedance/ai/model/objects/MainInitData;", "getMainInit", "()Lcom/bytedance/ai/model/objects/MainInitData;", "setMainInit", "(Lcom/bytedance/ai/model/objects/MainInitData;)V", PromotionProductPrivilegesStruct.SERVICES, "Lcom/bytedance/ai/model/objects/ServiceInfo;", "getServices", "setServices", ComplianceResult.JsonKey.PERMISSIONS, "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "darkMode", "", "getDarkMode", "()Z", "setDarkMode", "(Z)V", "chat", "getChat", "setChat", "toolRuntimeEntry", "getToolRuntimeEntry", "setToolRuntimeEntry", "settings", "Lcom/bytedance/ai/model/objects/AppletSettings;", "getSettings", "()Lcom/bytedance/ai/model/objects/AppletSettings;", "setSettings", "(Lcom/bytedance/ai/model/objects/AppletSettings;)V", "chatConfig", "Lcom/bytedance/ai/model/objects/AppletChatConfig;", "getChatConfig", "()Lcom/bytedance/ai/model/objects/AppletChatConfig;", "homePath", "getHomePath", "internalUniqueId", "getInternalUniqueId", "internalUniqueId$delegate", "Lkotlin/Lazy;", "loadMainJS", "", "callback", "Lkotlin/Function3;", "Lcom/bytedance/ai/utils/ResponseData;", "Lcom/bytedance/ai/utils/LoadGeckoCallback;", "forRts", "getUniqueId", "appId", "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "describeContents", "", "writeToParcel", "dest", "flags", "findPageByUrl", "url", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Applet extends AIPackage {
    public static final Parcelable.Creator<Applet> CREATOR = null;
    public final String K;
    public final List<Page> L;
    public final List<Plugin> M;
    public final String N;
    public final String O;
    public final String P;
    public String Q;
    public final String R;
    public ArrayList<Widget> S;
    public final String T;
    public MainInitData U;
    public List<ServiceInfo> V;
    public Map<String, PermissionDetail> W;
    public boolean X;
    public String Y;
    public String Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public AppletSettings f36924k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final transient Lazy f36925p0;

    public static final class a implements Parcelable.Creator<Applet> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Applet createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new Applet(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Applet[] newArray(int r100) {
            return new Applet[r100];
        }
    }

    public static final class b {
    }

    public Applet() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287);
    }

    @Override // com.bytedance.ai.model.objects.AIPackage, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String d() {
        return (String) this.f36925p0.getValue();
    }

    public final String o() {
        if (f.g(this.K) == false) goto L7;
        return this.K;
    L7:
        return this.f36894a;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String a() {
        return this.K;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final AIPackage.AIPackageType c() {
        return AIPackage.AIPackageType.APPLET;
    }

    public Applet(Parcel r210) {
        Intrinsics.checkNotNullParameter(r210, "parcel");
        String r100 = r210.readString();
        String r211 = "";
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r210.readString();
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        long r104 = r210.readLong();
        String r105 = r210.readString();
        String r106 = r210.readString();
        if (r106 != null) goto L13;
        String r107 = "";
    L14:
        String r108 = r210.readString();
        if (r108 != null) goto L17;
        String r109 = "";
    L18:
        Icons r110 = (Icons) r210.readParcelable(Icons.class.getClassLoader());
        String r111 = r210.readString();
        if (r111 != null) goto L21;
        String r112 = "";
    L22:
        String r113 = r210.readString();
        if (r113 != null) goto L25;
        String r114 = "";
    L26:
        String r115 = r210.readString();
        if (r115 != null) goto L29;
        String r116 = "";
    L30:
        ArrayList<String> r117 = r210.createStringArrayList();
        String r118 = r210.readString();
        if (r118 != null) goto L33;
        String r119 = "";
    L34:
        String r120 = r210.readString();
        if (r120 != null) goto L37;
        String r121 = "";
    L38:
        ArrayList r122 = r210.createTypedArrayList(Page.CREATOR);
        ArrayList r123 = r210.createTypedArrayList(Plugin.CREATOR);
        String r124 = r210.readString();
        if (r124 != null) goto L41;
        String r125 = "";
    L42:
        String r126 = r210.readString();
        if (r126 != null) goto L45;
        String r212 = "";
    L46:
        String r127 = r210.readString();
        if (r127 != null) goto L49;
        String r213 = "";
    L50:
        this(r101, r103, r104, r105, r107, r109, r110, r112, r114, r116, r117, r119, r121, r122, r123, r125, r212, r213, 262144);
        String r128 = r210.readString();
        if (r128 != null) goto L53;
        r128 = "";
    L53:
        this.Q = r128;
        String r129 = r210.readString();
        if (r129 != null) goto L56;
        r129 = "";
    L56:
        this.R = r129;
        String r130 = r210.readString();
        if (r130 != null) goto L59;
        r130 = "";
    L59:
        this.T = r130;
        this.U = (MainInitData) r210.readParcelable(MainInitData.class.getClassLoader());
        this.V = r210.createTypedArrayList(ServiceInfo.CREATOR);
        h(r210);
        if (r210.readByte() != 0) goto L64;
        boolean r131 = false;
    L65:
        this.X = r131;
        AppletSettings r132 = null;
        String r133 = r210.readString();     // Catch: Exception -> L68
    L69:
        this.Y = r133;
        r211 = r210.readString();     // Catch: Exception -> L76
    L71:
        this.Z = r211;
        r132 = (AppletSettings) r210.readParcelable(AppletSettings.class.getClassLoader());     // Catch: Exception -> L77
    L74:
        this.f36924k0 = r132;
        return;
    L68:
        r133 = null;
    L64:
        r131 = true;
        goto L65
    L49:
        r213 = r127;
        goto L50
    L45:
        r212 = r126;
        goto L46
    L41:
        r125 = r124;
        goto L42
    L37:
        r121 = r120;
        goto L38
    L33:
        r119 = r118;
        goto L34
    L29:
        r116 = r115;
        goto L30
    L25:
        r114 = r113;
        goto L26
    L21:
        r112 = r111;
        goto L22
    L17:
        r109 = r108;
        goto L18
    L13:
        r107 = r106;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    public final Page q(String r100) {
        Object r101 = null;
        if (r100 == null) goto L27;
        String r102 = c.a(r100);
        if (r102 == null) goto L28;
        List<Page> r103 = this.L;
        if (r103 == null) goto L29;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L21;
        Object r105 = r104.next();
        Page r106 = (Page) r105;
        if (Intrinsics.areEqual(r106.getPath(), r102) == false) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == false) goto L10;
        r101 = r105;
        goto L21
    L14:
        if (Intrinsics.areEqual(r106.pageId(), r102) == true) goto L17;
        r107 = false;
    L21:
        return (Page) r101;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.Q = r100;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f36894a);
        r100.writeString(this.f36895b);
        r100.writeLong(this.f36896c);
        r100.writeString(this.f36897d);
        r100.writeString(this.f36898e);
        r100.writeString(this.f36899f);
        r100.writeParcelable(this.f36900g, r101);
        r100.writeString(this.f36901h);
        r100.writeString(this.f36902i);
        r100.writeString(this.f36903j);
        r100.writeStringList(this.f36904k);
        r100.writeString(this.f36905l);
        r100.writeString(this.K);
        r100.writeTypedList(this.L);
        r100.writeTypedList(this.M);
        r100.writeString(this.N);
        r100.writeString(this.O);
        r100.writeString(this.P);
        r100.writeString(this.Q);
        r100.writeString(this.R);
        r100.writeString(this.T);
        r100.writeParcelable(this.U, r101);
        r100.writeTypedList(this.V);
        super.writeToParcel(r100, r101);
        r100.writeByte(this.X ? 1 : 0);
        r100.writeString(this.Y);
        r100.writeString(this.Z);
        r100.writeParcelable(this.f36924k0, r101);
    }

    public /* synthetic */ Applet(String r210, String r211, long r212, String r213, String r310, String r311, Icons r312, String r313, String r314, String r315, List r316, String r317, String r318, List r319, List r410, String r411, String r412, String r413, int r414) {
        String r100 = "";
        if ((r414 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r414 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r110 = "";
    L27:
        if ((r414 & 64) == 0) goto L29;
        Icons r111 = new Icons();
    L31:
        if ((r414 & 128) == 0) goto L33;
        String r112 = "";
    L35:
        if ((r414 & 256) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r114 = "";
    L43:
        if ((r414 & 1024) == 0) goto L45;
        List r115 = new ArrayList();
    L47:
        if ((r414 & 2048) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r414 & 4096) == 0) goto L53;
        String r117 = "";
    L55:
        if ((r414 & 8192) == 0) goto L57;
        List r118 = new ArrayList();
    L59:
        if ((r414 & 16384) == 0) goto L61;
        List r119 = new ArrayList();
    L63:
        if ((32768 & r414) == 0) goto L65;
        String r214 = "";
    L67:
        if ((65536 & r414) == 0) goto L69;
        String r215 = "";
    L71:
        if ((131072 & r414) == 0) goto L73;
        String r216 = "";
    L75:
        if ((r414 & 262144) != 0) goto L78;
        r100 = null;
    L78:
        this(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r100);
        return;
    L73:
        r216 = r413;
        goto L75
    L69:
        r215 = r412;
        goto L71
    L65:
        r214 = r411;
        goto L67
    L61:
        r119 = r410;
        goto L63
    L57:
        r118 = r319;
        goto L59
    L53:
        r117 = r318;
        goto L55
    L49:
        r116 = r317;
        goto L51
    L45:
        r115 = r316;
        goto L47
    L41:
        r114 = r315;
        goto L43
    L37:
        r113 = r314;
        goto L39
    L33:
        r112 = r313;
        goto L35
    L29:
        r111 = r312;
        goto L31
    L25:
        r110 = r311;
        goto L27
    L21:
        r105 = r310;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    public Applet(String r110, final String r111, long r112, String r113, String r210, String r211, Icons r212, String r213, String r214, String r215, List<String> r216, String r217, String r218, List<Page> r219, List<Plugin> r310, String r311, String r312, String r313, String r314) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "packageName");
        Intrinsics.checkNotNullParameter(r210, "versionName");
        Intrinsics.checkNotNullParameter(r211, "description");
        Intrinsics.checkNotNullParameter(r213, "manifestVersion");
        Intrinsics.checkNotNullParameter(r214, "prop");
        Intrinsics.checkNotNullParameter(r215, "recommend");
        Intrinsics.checkNotNullParameter(r217, "appGroup");
        Intrinsics.checkNotNullParameter(r218, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r311, "botId");
        Intrinsics.checkNotNullParameter(r312, "appletEntry");
        Intrinsics.checkNotNullParameter(r314, "runtimeVersion");
        super(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217);
        this.K = r218;
        this.L = r219;
        this.M = r310;
        this.N = r311;
        this.O = r312;
        this.P = r313;
        this.Q = "";
        this.R = "";
        this.S = new ArrayList();
        this.T = "";
        this.V = new ArrayList();
        this.W = new LinkedHashMap();
        this.X = true;
        this.Z = "";
        Intrinsics.checkNotNullParameter(r314, "<set-?>");
        this.C = r314;
        this.f36925p0 = LazyKt.lazy(new h5.a(r111, this));
    }
}
