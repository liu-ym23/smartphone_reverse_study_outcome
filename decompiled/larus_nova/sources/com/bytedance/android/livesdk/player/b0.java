package com.bytedance.android.livesdk.player;

import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f155155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f155156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<String> f155157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f155158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f155159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f155160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f155161g;

    public b0() {
        Intrinsics.checkNotNullParameter("", "enableLiveIo");
        Intrinsics.checkNotNullParameter("", "liveIoPlay");
        Intrinsics.checkNotNullParameter("", "liveIoP2P");
        Intrinsics.checkNotNullParameter("", "p2pType");
        this.f155158d = "";
        this.f155159e = "";
        this.f155160f = "";
        this.f155161g = "";
        this.f155155a = -1;
        this.f155157c = CollectionsKt.arrayListOf(new String[]{"start_play", PortraitEngine.LABEL_FIRST_FRAME, "play_stop", "playing"});
    }
}
