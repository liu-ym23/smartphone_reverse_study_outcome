package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import com.bytedance.android.livesdkapi.model.AesBoostConfig;
import com.bytedance.android.livesdkapi.model.AudioChannelExpandParams;
import com.bytedance.android.livesdkapi.model.AudioFirst;
import com.bytedance.android.livesdkapi.model.AudioFrameDrop;
import com.bytedance.android.livesdkapi.model.AudioTTAPParams;
import com.bytedance.android.livesdkapi.model.P2PSuggestInfo;
import com.bytedance.android.livesdkapi.model.PlayerSpeedRangeParams;
import com.bytedance.android.livesdkapi.model.RealTimeIP;
import com.bytedance.android.livesdkapi.model.SharpenParams;
import com.bytedance.android.livesdkapi.model.StreamSrConfig;
import com.bytedance.android.livesdkapi.model.SuperResolutionConfig;
import com.bytedance.android.livesdkapi.model.SvcParams;
import com.bytedance.android.livesdkapi.model.VolumeBalanceParams;
import com.bytedance.android.livesdkapi.model.VolumeGainParams;

/* JADX INFO: loaded from: classes11.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f155979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f155980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f155981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f155982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VolumeBalanceParams f155983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VolumeGainParams f155984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioChannelExpandParams f155985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioTTAPParams f155986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public P2PSuggestInfo f155987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public StreamSrConfig.SrScale f155988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public StreamSrConfig f155989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f155990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f155991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f155992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SvcParams f155993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PlayerSpeedRangeParams f155994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AesBoostConfig f155995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SharpenParams f155996r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SuperResolutionConfig f155997s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f155998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RealTimeIP f155999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AudioFirst f156000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AudioFrameDrop f156001w;

    public final String toString() {
        return "InterceptResult(qosConstraintOpt=" + this.f155981c + ", resolution='" + this.f155982d + "')";
    }

    public q() {
        this.f155980b = "";
        this.f155981c = -1;
        this.f155982d = "";
        this.f155990l = -1;
        this.f155991m = -1;
        this.f155992n = "";
    }
}
