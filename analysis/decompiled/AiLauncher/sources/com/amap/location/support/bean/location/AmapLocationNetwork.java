package com.amap.location.support.bean.location;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import m4.AbstractC4898a;

/* loaded from: classes.dex */
public class AmapLocationNetwork extends AmapLocation implements Serializable {

    /* renamed from: D, reason: collision with root package name */
    public String f18105D;

    /* renamed from: E, reason: collision with root package name */
    public String f18106E;

    /* renamed from: F, reason: collision with root package name */
    public String f18107F;

    /* renamed from: G, reason: collision with root package name */
    public String f18108G;

    /* renamed from: H, reason: collision with root package name */
    public String f18109H;

    /* renamed from: I, reason: collision with root package name */
    public String f18110I;

    /* renamed from: J, reason: collision with root package name */
    public String f18111J;

    /* renamed from: K, reason: collision with root package name */
    public String f18112K;

    /* renamed from: L, reason: collision with root package name */
    public String f18113L;

    /* renamed from: M, reason: collision with root package name */
    public String f18114M;

    /* renamed from: N, reason: collision with root package name */
    public String f18115N;

    /* renamed from: O, reason: collision with root package name */
    public String f18116O;

    /* renamed from: P, reason: collision with root package name */
    public String f18117P;

    /* renamed from: Q, reason: collision with root package name */
    public String f18118Q;

    /* renamed from: R, reason: collision with root package name */
    public String f18119R;

    /* renamed from: S, reason: collision with root package name */
    public String f18120S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f18121T;

    /* renamed from: U, reason: collision with root package name */
    public int f18122U;

    /* renamed from: V, reason: collision with root package name */
    public String f18123V;

    /* renamed from: W, reason: collision with root package name */
    public float f18124W;

    /* renamed from: X, reason: collision with root package name */
    public byte[] f18125X;

    /* renamed from: Y, reason: collision with root package name */
    public int f18126Y;

    /* renamed from: Z, reason: collision with root package name */
    public String f18127Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f18128a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f18129b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f18130c0;

    public AmapLocationNetwork() {
        super("network", 1, AbstractC4898a.ERROR_UNKNOW);
        this.f18105D = Const.STR_NEW;
        this.f18106E = "";
        this.f18107F = "";
        this.f18108G = "";
        this.f18109H = "";
        this.f18110I = "";
        this.f18111J = "";
        this.f18112K = "";
        this.f18113L = "";
        this.f18114M = "";
        this.f18115N = "";
        this.f18116O = "";
        this.f18117P = "";
        this.f18118Q = "";
        this.f18119R = "";
        this.f18120S = null;
        this.f18121T = false;
        this.f18122U = -1;
        this.f18123V = "";
        this.f18124W = 0.0f;
        this.f18125X = null;
        this.f18126Y = -1;
        this.f18127Z = "";
        this.f18129b0 = false;
        this.f18130c0 = "";
    }

    public String G() {
        return this.f18110I;
    }

    public String H() {
        return this.f18118Q;
    }

    public String J() {
        return this.f18105D;
    }

    public String K() {
        return this.f18120S;
    }

    public String L() {
        return this.f18113L;
    }

    public String M() {
        return this.f18108G;
    }

    public int N() {
        return this.f18122U;
    }

    public String O() {
        return this.f18111J;
    }

    public String P() {
        return this.f18109H;
    }

    public String Q() {
        return this.f18114M;
    }

    public int R() {
        if (a0()) {
            return 2;
        }
        if (Const.STR_NEW.equals(J())) {
            return 1;
        }
        if (Const.STR_MEM.equals(J())) {
            return 3;
        }
        if (Const.STR_FILE.equals(J()) || Const.TYPE_OFFLINE_WIFI.equals(J())) {
            return 4;
        }
        return "mini".equals(J()) ? 5 : 0;
    }

    public String S() {
        return this.f18123V;
    }

    public String T() {
        return this.f18117P;
    }

    public String U() {
        return this.f18119R;
    }

    public String V() {
        return this.f18112K;
    }

    public String W() {
        return this.f18107F;
    }

    public String X() {
        return this.f18106E;
    }

    public String Y() {
        return this.f18115N;
    }

    public String Z() {
        return this.f18116O;
    }

    public boolean a0() {
        return this.f18128a0;
    }
}
