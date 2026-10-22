package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import h5.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 R2\u00020\u0001:\u0001RBÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b\u001c\u0010 J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010I\u001a\u00020\u0003H\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020\u0019H\u0016J\u0018\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u0019H\u0016R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010%R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010%R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010%R$\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u00109\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010%R$\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010E\u001a\u00020\u00038BX\u0083\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bF\u0010\"¨\u0006S"}, d2 = {"Lcom/bytedance/ai/model/objects/Widget;", "Lcom/bytedance/ai/model/objects/AIPackage;", "name", "", "packageName", RuleConditionBean.VERSION_CODE_KEY, "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", "recommend", "keywords", "", "appGroup", "widgetId", "entry", "input", BdpAppEventConstant.PARAMS_OUTPUT, "border", "", "boxType", "", "titleType", "runtimeVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getWidgetId", "()Ljava/lang/String;", "getEntry", "setEntry", "(Ljava/lang/String;)V", "getInput", "setInput", "getOutput", "setOutput", "getBorder", "()Z", "setBorder", "(Z)V", "getBoxType", "()I", "setBoxType", "(I)V", "getTitleType", "()Ljava/lang/Integer;", "setTitleType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ThumbGlideUrl.SOURCE_TEMPLATE, "getTemplate$annotations", "()V", "getTemplate", "setTemplate", "botId", "getBotId$annotations", "getBotId", "setBotId", "appSettings", "getAppSettings", "()Ljava/util/List;", "setAppSettings", "(Ljava/util/List;)V", "internalUniqueId", "getInternalUniqueId", "internalUniqueId$delegate", "Lkotlin/Lazy;", "appId", "getUniqueId", "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Widget extends AIPackage {
    public static final Parcelable.Creator<Widget> CREATOR = null;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final boolean O;
    public final int P;
    public final Integer Q;
    public final String R;
    public final String S;
    public List<String> T;
    public final transient Lazy U;

    public static final class a implements Parcelable.Creator<Widget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Widget createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new Widget(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Widget[] newArray(int r100) {
            return new Widget[r100];
        }
    }

    public static final class b {
    }

    public Widget() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, 1048575);
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
        return (String) this.U.getValue();
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final String a() {
        return this.K;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage
    public final AIPackage.AIPackageType c() {
        return AIPackage.AIPackageType.WIDGET;
    }

    public Widget(Parcel r210) {
        Intrinsics.checkNotNullParameter(r210, "parcel");
        String r100 = r210.readString();
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
        String r122 = r210.readString();
        if (r122 != null) goto L41;
        String r123 = "";
    L42:
        String r124 = r210.readString();
        if (r124 != null) goto L45;
        String r125 = "";
    L46:
        String r126 = r210.readString();
        if (r126 != null) goto L49;
        String r211 = "";
    L51:
        if (r210.readByte() == 0) goto L53;
        boolean r212 = true;
    L54:
        String r127 = r121;
        String r128 = r123;
        String r129 = r125;
        String r130 = r211;
        boolean r131 = r212;
        this(r101, r103, r104, r105, r107, r109, r110, r112, r114, r116, r117, r119, r127, r128, r129, r130, r131, r210.readInt(), Integer.valueOf(r210.readInt()), null, 524288);
        String r132 = r210.readString();
        if (r132 != null) goto L57;
        r132 = "";
    L57:
        this.R = r132;
        String r133 = r210.readString();
        if (r133 != null) goto L60;
        r133 = "";
    L60:
        this.S = r133;
        ArrayList<String> r134 = r210.createStringArrayList();
        if (r134 != null) goto L64;
        r134 = new ArrayList();
    L64:
        this.T = r134;
        h(r210);
        return;
    L53:
        r212 = false;
        goto L54
    L49:
        r211 = r126;
        goto L51
    L45:
        r125 = r124;
        goto L46
    L41:
        r123 = r122;
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
        r100.writeString(this.L);
        r100.writeString(this.M);
        r100.writeString(this.N);
        r100.writeByte(this.O ? 1 : 0);
        r100.writeInt(this.P);
        Integer r102 = this.Q;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        r100.writeString(this.R);
        r100.writeString(this.S);
        r100.writeStringList(this.T);
        super.writeToParcel(r100, r101);
        return;
    L5:
        r103 = -1;
        goto L6
    }

    public Widget(String r110, final String r111, long r112, String r210, String r211, String r212, Icons r213, String r214, String r215, String r216, List<String> r217, String r218, String r219, String r310, String r311, String r312, boolean r313, int r314, Integer r315, String r316) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "packageName");
        Intrinsics.checkNotNullParameter(r211, "versionName");
        Intrinsics.checkNotNullParameter(r212, "description");
        Intrinsics.checkNotNullParameter(r214, "manifestVersion");
        Intrinsics.checkNotNullParameter(r215, "prop");
        Intrinsics.checkNotNullParameter(r216, "recommend");
        Intrinsics.checkNotNullParameter(r218, "appGroup");
        Intrinsics.checkNotNullParameter(r219, "widgetId");
        Intrinsics.checkNotNullParameter(r310, "entry");
        Intrinsics.checkNotNullParameter(r311, "input");
        Intrinsics.checkNotNullParameter(r312, BdpAppEventConstant.PARAMS_OUTPUT);
        Intrinsics.checkNotNullParameter(r316, "runtimeVersion");
        super(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        this.K = r219;
        this.L = r310;
        this.M = r311;
        this.N = r312;
        this.O = r313;
        this.P = r314;
        this.Q = r315;
        this.R = "";
        this.S = "";
        this.T = new ArrayList();
        this.U = LazyKt.lazy(new i(r111, this));
        Intrinsics.checkNotNullParameter(r316, "<set-?>");
        this.C = r316;
    }

    public /* synthetic */ Widget(String r210, String r211, long r212, String r213, String r214, String r310, Icons r311, String r312, String r313, String r314, List r315, String r316, String r317, String r318, String r319, String r410, boolean r411, int r412, Integer r413, String r414, int r415) {
        if ((r415 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r415 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r415 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r415 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r415 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r415 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r415 & 64) == 0) goto L29;
        Icons r106 = new Icons();
    L31:
        if ((r415 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r415 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r415 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r415 & 1024) == 0) goto L45;
        List r113 = new ArrayList();
    L47:
        if ((r415 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r415 & 4096) == 0) goto L53;
        String r115 = "";
    L54:
        String r116 = "";
        if ((r415 & 8192) == 0) goto L57;
        String r107 = r116;
    L58:
        String r117 = r107;
        if ((r415 & 16384) == 0) goto L61;
        String r108 = r116;
    L63:
        if ((r415 & 32768) == 0) goto L65;
        String r118 = r116;
    L66:
        int r215 = 0;
        if ((r415 & 65536) == 0) goto L69;
        boolean r119 = false;
    L71:
        if ((r415 & 131072) != 0) goto L75;
        r215 = r412;
    L75:
        if ((r415 & 262144) == 0) goto L77;
        Integer r216 = -1;
    L79:
        if ((r415 & 524288) != 0) goto L82;
        r116 = r414;
    L82:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r117, r108, r118, r119, r215, r216, r116);
        return;
    L77:
        r216 = r413;
        goto L79
    L69:
        r119 = r411;
        goto L71
    L65:
        r118 = r410;
        goto L66
    L61:
        r108 = r319;
        goto L63
    L57:
        r107 = r318;
        goto L58
    L53:
        r115 = r317;
        goto L54
    L49:
        r114 = r316;
        goto L51
    L45:
        r113 = r315;
        goto L47
    L41:
        r112 = r314;
        goto L43
    L37:
        r111 = r313;
        goto L39
    L33:
        r110 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
