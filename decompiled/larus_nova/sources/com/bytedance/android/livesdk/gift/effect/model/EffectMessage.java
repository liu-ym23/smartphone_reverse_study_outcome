package com.bytedance.android.livesdk.gift.effect.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.a1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.message.model.zb;
import iy1.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v12.c;

/* JADX INFO: loaded from: classes9.dex */
public final class EffectMessage implements c {
    public List<String> A;
    public final Map<Integer, Long> B;
    public h1 C;
    public int D;
    public j3 E;
    public w F;
    public int G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f126016J;
    public boolean K;
    public int L;
    public List<Long> M;
    public String N;
    public boolean O;
    public List<n3> P;
    public int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f126017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f126018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f126019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f126020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Long, a> f126021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f126022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f126023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IBaseUser f126024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IBaseUser f126025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f126026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zb f126027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f126028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f126029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f126030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f126031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o0 f126032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.model.a f126033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f126034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f126035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a1 f126036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f126037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f126038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f126039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f126040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f126041y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m0 f126042z;

    public static class PlayableAsset {
        private String lynxSchema;
        private String passThroughData;
        private int resourceType;

        public PlayableAsset() {
        }

        public String getLynxSchema() {
            return this.lynxSchema;
        }

        public String getPassThroughData() {
            return this.passThroughData;
        }

        public int getResourceType() {
            return this.resourceType;
        }

        public void setLynxSchema(String r100) {
            this.lynxSchema = r100;
        }

        public void setPassThroughData(String r100) {
            this.passThroughData = r100;
        }

        public void setResourceType(int r100) {
            this.resourceType = r100;
        }
    }

    public EffectMessage() {
        this.f126021e = new LinkedHashMap();
        this.f126030n = "";
        this.f126031o = false;
        this.A = new ArrayList();
        this.B = new HashMap();
        this.C = null;
        this.D = 0;
        this.H = false;
        this.I = -1;
        this.f126016J = 0;
        this.K = false;
        this.L = 0;
        this.M = new ArrayList();
        this.N = "";
        this.O = false;
        this.P = null;
    }

    @Override // v12.c
    public final String b() {
        return this.f126020d;
    }

    @Override // v12.c
    public final boolean c() {
        return this.f126031o;
    }

    @Override // v12.c
    public final String getDescription() {
        return this.f126026j;
    }

    @Override // v12.c
    public final long getEffectId() {
        return this.f126018b;
    }

    @Override // v12.c
    public final IBaseUser getFromUser() {
        return this.f126025i;
    }

    @Override // v12.c
    public final long getGiftId() {
        return this.f126028l;
    }

    @Override // v12.c
    public final String getInteractGiftInfo() {
        return this.f126034r;
    }

    @Override // v12.c
    public final String getLogId() {
        return this.f126030n;
    }

    @Override // v12.c
    public final long getMsgId() {
        return this.f126017a;
    }

    @Override // v12.c
    public final int getPriority() {
        return this.f126019c;
    }

    @Override // v12.c
    public final long getRepeatCount() {
        return this.f126029m;
    }

    @Override // v12.c
    public final IBaseUser getToUser() {
        return this.f126024h;
    }

    @Override // v12.c
    public final String getTraceId() {
        return this.f126041y;
    }

    @Override // v12.c
    public final boolean isLocal() {
        return this.f126039w;
    }

    public final void a(int r100, long r101) {
        Map<Integer, Long> r102 = this.B;
        HashMap r103 = (HashMap) r102;
        r103.put(Integer.valueOf(r100), Long.valueOf(r101));
    }
}
