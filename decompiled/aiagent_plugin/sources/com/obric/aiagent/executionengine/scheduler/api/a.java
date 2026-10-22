package com.obric.aiagent.executionengine.scheduler.api;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.Ext;
import d.h.b.h;

/* JADX INFO: compiled from: IEventManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("todo_actions")
    private JsonArray f17950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(Ext.KEY_JOB_ID)
    private long f17951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("event_id")
    private long f17952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("event_counts")
    private int f17953d;

    public a(JsonArray r1, long r2, long r4, int r6) {
        this.f17950a = r1;
        this.f17951b = r2;
        this.f17952c = r4;
        this.f17953d = r6;
    }

    public /* synthetic */ a(JsonArray r5, long r6, long r8, int r10, int r11, h r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = null;
    L5:
        long r0 = -1;
        if ((r11 & 2) == 0) goto L8;
        long r2 = -1;
    L10:
        if ((r11 & 4) != 0) goto L14;
        r0 = r8;
    L14:
        if ((r11 & 8) == 0) goto L16;
        r10 = 1;
    L16:
        this(r5, r2, r0, r10);
        return;
    L8:
        r2 = r6;
        goto L10
    }

    public final JsonArray a() {
        return this.f17950a;
    }

    public final long b() {
        return this.f17951b;
    }

    public final long c() {
        return this.f17952c;
    }

    public final int d() {
        return this.f17953d;
    }
}
