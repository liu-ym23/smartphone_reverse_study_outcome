package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u008d\u00012\u00020\u0001:\n\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0016J\u0010\u0010{\u001a\u00020|2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010}\u001a\u00020|2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010~\u001a\u00020HH\u0016J\b\u0010\u007f\u001a\u00020HH\u0016J\t\u0010\u0080\u0001\u001a\u00020|H\u0016J\t\u0010\u0081\u0001\u001a\u00020|H\u0016J\u0010\u0010\u0082\u0001\u001a\u00020|2\u0007\u0010\u0083\u0001\u001a\u00020HJ\u0007\u0010\u0084\u0001\u001a\u00020XJ\u0010\u0010\u0085\u0001\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020zJ\t\u0010\u0087\u0001\u001a\u00020\u0003H&J\t\u0010\u0088\u0001\u001a\u00020\u0003H&J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H&J\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010\u008c\u0001\u001a\u00020XR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001e\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010.R\u001e\u00102\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010*R\u001e\u00105\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010*R\u001e\u00108\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010*R\u001e\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010*R\u001e\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010*R\u001e\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010*R\u001e\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010.R\"\u0010G\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010N\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0018\"\u0004\bP\u0010.R\u001e\u0010Q\u001a\u00020R8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020X8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020X8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R \u0010^\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0018\"\u0004\b`\u0010.R\u001e\u0010a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0018\"\u0004\bc\u0010.R\u001e\u0010d\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\u001e\u0010l\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR\u001e\u0010o\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010f\"\u0004\bq\u0010hR\u001e\u0010r\u001a\u00020s8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010y8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage;", "Landroid/os/Parcelable;", "name", "", "packageName", RuleConditionBean.VERSION_CODE_KEY, "", "scmVersion", "versionName", "description", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "manifestVersion", "prop", "recommend", "keywords", "", "appGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "getPackageName", "getVersionCode", "()J", "getScmVersion", "getVersionName", "getDescription", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "getManifestVersion", "getProp", "getRecommend", "getKeywords", "()Ljava/util/List;", "getAppGroup", "id", "getId", "setId", "(J)V", "digest", "getDigest", "setDigest", "(Ljava/lang/String;)V", "renderType", "getRenderType", "setRenderType", "size", "getSize", "setSize", "ft", "getFt", "setFt", "it", "getIt", "setIt", "ut", "getUt", "setUt", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "createTime", "getCreateTime", "setCreateTime", "installStatus", "getInstallStatus", "setInstallStatus", "readyForDeleting", "", "getReadyForDeleting", "()Ljava/lang/Integer;", "setReadyForDeleting", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sessionId", "getSessionId", "setSessionId", "status", "Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "getStatus", "()Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "setStatus", "(Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;)V", "isPermanent", "", "()Z", "setPermanent", "(Z)V", "isDebug", "setDebug", "resFrom", "getResFrom", "setResFrom", "runtimeVersion", "getRuntimeVersion", "setRuntimeVersion", "hasKeyStore", "getHasKeyStore", "()I", "setHasKeyStore", "(I)V", "verifySignature", "getVerifySignature", "setVerifySignature", "appType", "getAppType", "setAppType", "sourceType", "getSourceType", "setSourceType", "useCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getUseCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setUseCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "useCountListener", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ai/model/objects/AIPackage$IUseCountChangedListener;", "readFromParcel", "", "writeToParcel", "flags", "describeContents", "markInUse", "markOutOfUse", "resetUseCount", "count", "isRunning", "setUseCountListener", "listener", "getUniqueId", "appId", "getPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "getIconUrl", "isInternalApp", "Companion", "AIPackageType", "PackageStatus", "ResFrom", "IUseCountChangedListener", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AIPackage implements Parcelable {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f36893J = 0;
    public boolean A;
    public String B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public final AtomicInteger H;
    public transient WeakReference<b> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f36896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f36897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f36898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f36899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Icons f36900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f36901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f36902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f36903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f36904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f36905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f36906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f36907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f36908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f36909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f36910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f36911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f36912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f36913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f36914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f36915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f36916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f36917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PackageStatus f36918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f36919z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "", "<init>", "(Ljava/lang/String;I)V", "APPLET", "WIDGET", "UNKNOWN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AIPackageType extends Enum<AIPackageType> {
        public static final AIPackageType APPLET = null;
        public static final AIPackageType UNKNOWN = null;
        public static final AIPackageType WIDGET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AIPackageType[] f36920a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36921b = null;

        public static EnumEntries<AIPackageType> getEntries() {
            return f36921b;
        }

        static {
            AIPackageType r100 = new AIPackageType("APPLET", 0);
            APPLET = r100;
            AIPackageType r101 = new AIPackageType("WIDGET", 1);
            WIDGET = r101;
            AIPackageType r102 = new AIPackageType("UNKNOWN", 2);
            UNKNOWN = r102;
            AIPackageType[] r103 = {r100, r101, r102};
            f36920a = r103;
            f36921b = EnumEntriesKt.enumEntries(r103);
        }

        public static AIPackageType[] values() {
            return (AIPackageType[]) f36920a.clone();
        }

        public static AIPackageType valueOf(String r100) {
            return (AIPackageType) r27.a.a(AIPackageType.class, r100);
        }

        public AIPackageType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "UPDATING", "INSTALLING", "DELETING", "BASE_READY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PackageStatus extends Enum<PackageStatus> {
        public static final PackageStatus BASE_READY = null;
        public static final PackageStatus DELETING = null;
        public static final PackageStatus INSTALLING = null;
        public static final PackageStatus READY = null;
        public static final PackageStatus UPDATING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PackageStatus[] f36922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36923b = null;

        public static EnumEntries<PackageStatus> getEntries() {
            return f36923b;
        }

        static {
            PackageStatus r100 = new PackageStatus("READY", 0);
            READY = r100;
            PackageStatus r101 = new PackageStatus("UPDATING", 1);
            UPDATING = r101;
            PackageStatus r102 = new PackageStatus("INSTALLING", 2);
            INSTALLING = r102;
            PackageStatus r103 = new PackageStatus("DELETING", 3);
            DELETING = r103;
            PackageStatus r104 = new PackageStatus("BASE_READY", 4);
            BASE_READY = r104;
            PackageStatus[] r105 = {r100, r101, r102, r103, r104};
            f36922a = r105;
            f36923b = EnumEntriesKt.enumEntries(r105);
        }

        public static PackageStatus[] values() {
            return (PackageStatus[]) f36922a.clone();
        }

        public static PackageStatus valueOf(String r100) {
            return (PackageStatus) r27.a.a(PackageStatus.class, r100);
        }

        public PackageStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static String a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            Intrinsics.checkNotNullParameter(r101, "appId");
            return "pkg:" + r100 + "_id:" + r101;
        }
    }

    public interface b {
        void a(String r100, String r101);

        void b(String r100, String r101);
    }

    static {
    }

    public abstract String a();

    public abstract AIPackageType c();

    public abstract String d();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AIPackage() {
        this("", "", 0, "", "", "", new Icons(), "", "", "", new ArrayList(), "");
    }

    public final String b() {
        Icons r100 = this.f36900g;
        if (r100 == null) goto L6;
        String r101 = r100.get3x();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Icons r102 = this.f36900g;
        if (r102 == null) goto L9;
        String r103 = r102.get2x();
    L10:
        if (r103 != null) goto L17;
        Icons r104 = this.f36900g;
        if (r104 == null) goto L15;
        return r104.get1x();
    L15:
        return null;
    L17:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public void e() {
        this.H.incrementAndGet();
        g.f37637a.d("AIManager", "-------AIPackage " + c() + ' ' + hashCode() + ": " + this.f36895b + ' ' + a() + " markInUse: " + this.H.get());
        WeakReference<b> r100 = this.I;
        if (r100 == null) goto L8;
        b r101 = r100.get();
        if (r101 == null) goto L9;
        r101.a(this.f36895b, a());
        return;
    L9:
        return;
    }

    public void g() {
        this.H.decrementAndGet();
        g.f37637a.d("AIManager", "-------AIPackage " + c() + ' ' + hashCode() + ": " + this.f36895b + ' ' + a() + " markOutOfUse: " + this.H.get());
        WeakReference<b> r100 = this.I;
        if (r100 == null) goto L8;
        b r101 = r100.get();
        if (r101 == null) goto L9;
        r101.b(this.f36895b, a());
        return;
    L9:
        return;
    }

    public final void h(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this.f36906m = r100.readLong();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f36907n = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f36908o = r103;
        this.f36909p = r100.readLong();
        this.f36910q = r100.readLong();
        this.f36911r = r100.readLong();
        this.f36912s = r100.readLong();
        this.f36913t = r100.readLong();
        this.f36914u = r100.readLong();
        String r104 = r100.readString();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.f36915v = r104;
        this.f36916w = Integer.valueOf(r100.readInt());
        this.f36917x = r100.readString();
        this.f36918y = PackageStatus.values()[r100.readInt()];
        boolean r105 = true;
        int r106 = 0;
        if (r100.readByte() == 0) goto L14;
        boolean r107 = true;
    L15:
        this.f36919z = r107;
        if (r100.readByte() != 0) goto L19;
        r105 = false;
    L19:
        this.A = r105;
        this.B = r100.readString();
        String r108 = r100.readString();     // Catch: Exception -> L24
        if (r108 == null) goto L26;
        r102 = r108;
    L26:
        this.C = r102;
        int r109 = r100.readInt();     // Catch: Exception -> L29
    L31:
        this.D = r109;
        r106 = r100.readInt();     // Catch: Exception -> L34
    L36:
        this.E = r106;
        int r110 = r100.readInt();     // Catch: Exception -> L39
    L41:
        this.F = r110;
        int r111 = r100.readInt();     // Catch: Exception -> L44
    L46:
        this.G = r111;
        return;
    L44:
        e = move-exception;
        g.f37637a.d("AIPackage", "read sourceType from parcel exception: " + e);
        r111 = 2;
    L39:
        e = move-exception;
        g.f37637a.d("AIPackage", "read appType from parcel exception: " + e);
        r110 = CastIntegerProtector.parseInt("1");
    L34:
        e = move-exception;
        g.f37637a.d("AIPackage", "read verifySignature from parcel exception: " + e);
    L29:
        e = move-exception;
        g.f37637a.d("AIPackage", "read hasKeyStore from parcel exception: " + e);
        r109 = 0;
    L24:
        e = move-exception;
        g.f37637a.d("AIPackage", "read runtimeVersion from parcel exception: " + e);
        goto L26
    L14:
        r107 = false;
        goto L15
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f36907n = r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f36915v = r100;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f36908o = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeLong(this.f36906m);
        r100.writeString(this.f36907n);
        r100.writeString(this.f36908o);
        r100.writeLong(this.f36909p);
        r100.writeLong(this.f36910q);
        r100.writeLong(this.f36911r);
        r100.writeLong(this.f36912s);
        r100.writeLong(this.f36913t);
        r100.writeLong(this.f36914u);
        r100.writeString(this.f36915v);
        Integer r102 = this.f36916w;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        r100.writeString(this.f36917x);
        r100.writeInt(this.f36918y.ordinal());
        r100.writeByte(this.f36919z ? 1 : 0);
        r100.writeByte(this.A ? 1 : 0);
        r100.writeString(this.B);
        r100.writeString(this.C);
        r100.writeInt(this.D);
        r100.writeInt(this.E);
        r100.writeInt(this.F);
        r100.writeInt(this.G);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public AIPackage(String r100, String r101, long r102, String r103, String r104, String r105, Icons r106, String r110, String r111, String r112, List<String> r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r104, "versionName");
        Intrinsics.checkNotNullParameter(r105, "description");
        Intrinsics.checkNotNullParameter(r110, "manifestVersion");
        Intrinsics.checkNotNullParameter(r111, "prop");
        Intrinsics.checkNotNullParameter(r112, "recommend");
        Intrinsics.checkNotNullParameter(r114, "appGroup");
        this.f36894a = r100;
        this.f36895b = r101;
        this.f36896c = r102;
        this.f36897d = r103;
        this.f36898e = r104;
        this.f36899f = r105;
        this.f36900g = r106;
        this.f36901h = r110;
        this.f36902i = r111;
        this.f36903j = r112;
        this.f36904k = r113;
        this.f36905l = r114;
        this.f36907n = "";
        this.f36908o = "";
        this.f36915v = "";
        this.f36916w = 0;
        this.f36918y = PackageStatus.READY;
        this.C = "";
        this.F = CastIntegerProtector.parseInt("1");
        this.G = 2;
        this.H = new AtomicInteger(0);
    }
}
