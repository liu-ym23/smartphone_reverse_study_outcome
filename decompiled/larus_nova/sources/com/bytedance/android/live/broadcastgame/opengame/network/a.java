package com.bytedance.android.live.broadcastgame.opengame.network;

import com.amap.api.col.s.ce;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.open.api.GetBootConfigResponse.Data")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001d\u0005\u0018B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "crypt", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "b", "()Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "setCrypt", "(Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;)V", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$a;", "methodList", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "setMethodList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a$c;", "domainAllowList", "d", "setDomainAllowList", "", "disableInteractIm", "Z", "c", "()Z", "setDisableInteractIm", "(Z)V", "blockConsumeList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBlockConsumeList", "", "liveSceneList", "f", "setLiveSceneList", "", "gameCategory", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setGameCategory", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("block_consume_list")
    protected boolean blockConsumeList;

    @SerializedName("room_crypt")
    protected b crypt;

    @SerializedName("disable_interact_im")
    protected boolean disableInteractIm;

    @SerializedName("domain_allow_list")
    protected List<c> domainAllowList;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_CATEGORY)
    protected String gameCategory;

    @SerializedName("live_scene")
    protected List<Integer> liveSceneList;

    @SerializedName("ability_list")
    protected List<C0989a> methodList;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.network.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.Ability")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$a;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "maxTimes", "I", "b", "()I", "setMaxTimes", "(I)V", "unitTime", "d", "setUnitTime", "", "", faceverify.w.META_COLL_KEY_AUTH_INFO, "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setAuthInfo", "(Ljava/util/Map;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0989a implements vh7.h {

        @SerializedName(ComplianceResult.JsonKey.AUTH_INFO)
        protected Map<String, Long> authInfo;

        @SerializedName("max_times")
        protected int maxTimes;

        @SerializedName("name")
        protected String name;

        @SerializedName("unit_time")
        protected int unitTime;

        public C0989a() {
            this.name = "";
        }

        public final Map<String, Long> a() {
            return this.authInfo;
        }

        public final int b() {
            return this.maxTimes;
        }

        public final String c() {
            return this.name;
        }

        public final int d() {
            return this.unitTime;
        }

        public C0989a(am3.g r110) {
            this.authInfo = new HashMap();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L33;
            if (r101 != 1) goto L8;
            this.name = am3.h.c(r110);
            goto L3
        L8:
            if (r101 != 2) goto L10;
            this.maxTimes = (int) r110.j();
            goto L3
        L10:
            if (r101 != 3) goto L12;
            this.unitTime = (int) r110.j();
            goto L3
        L12:
            if (r101 != 4) goto L13;
            long r102 = r110.c();
            String r103 = null;
            Long r104 = null;
        L15:
            int r105 = r110.f();
            if (r105 == (-1)) goto L22;
            if (r105 != 1) goto L18;
            r103 = am3.h.c(r110);
            goto L15
        L18:
            if (r105 != 2) goto L19;
            r104 = Long.valueOf(r110.j());
            goto L15
        L19:
            am3.h.e(r110);
            goto L15
        L22:
            r110.d(r102);
            Map<String, Long> r106 = this.authInfo;
            if (r103 == null) goto L29;
            if (r104 == null) goto L27;
            r106.put(r103, r104);
            goto L3
        L27:
            throw new IllegalStateException("Value must not be null");
        L29:
            throw new IllegalStateException("Key must not be null");
        L13:
            am3.h.e(r110);
            goto L3
        L33:
            r110.d(r100);
            if (this.name != null) goto L63;
            this.name = "";
            return;
        }
    }

    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.RoomCrypt")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$b;", "", "", "key", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("key")
        protected String key;

        public b() {
            this.key = "";
        }

        public final String a() {
            return this.key;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.key = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
            if (this.key != null) goto L19;
            this.key = "";
            return;
        }
    }

    @ProtoMessage("webcast.open.api.GetBootConfigResponse.Data.Domain")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/a$c;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "kind", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setKind", "(J)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("kind")
        protected long kind;

        @SerializedName("domain")
        protected String name;

        public c() {
            this.name = "";
            this.kind = 1;
        }

        public final long a() {
            return this.kind;
        }

        public final String b() {
            return this.name;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L11;
            if (r103 != 1) goto L7;
            this.name = am3.h.c(r100);
            goto L3
        L7:
            if (r103 != 2) goto L8;
            this.kind = r100.j();
            r102 = r102 | true;
            goto L3
        L8:
            am3.h.e(r100);
            goto L3
        L11:
            r100.d(r101);
            if (this.name != null) goto L15;
            this.name = "";
        L15:
            if ((r102 & true) == true) goto L27;
            this.kind = 1;
            return;
        }
    }

    public a() {
    }

    public final boolean a() {
        return this.blockConsumeList;
    }

    public final b b() {
        return this.crypt;
    }

    public final boolean c() {
        return this.disableInteractIm;
    }

    public final List<c> d() {
        return this.domainAllowList;
    }

    public final String e() {
        return this.gameCategory;
    }

    public final List<Integer> f() {
        return this.liveSceneList;
    }

    public final List<C0989a> g() {
        return this.methodList;
    }

    public a(am3.g r100) {
        this.methodList = new ArrayList();
        this.domainAllowList = new ArrayList();
        this.liveSceneList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.gameCategory = am3.h.c(r100);
        goto L3
    L8:
        List r103 = this.liveSceneList;
        Object r104 = Integer.valueOf(r100.i());
    L13:
        r103.add(r104);
        goto L3
    L9:
        this.blockConsumeList = am3.h.a(r100);
        goto L3
    L10:
        this.disableInteractIm = am3.h.a(r100);
        goto L3
    L11:
        r103 = this.domainAllowList;
        r104 = new c(r100);
        goto L13
    L12:
        r103 = this.methodList;
        r104 = new C0989a(r100);
        goto L13
    L14:
        this.crypt = new b(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
