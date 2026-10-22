package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftKmpInRoomService;
import com.bytedance.kmp.livesdk.gift.platform.GiftContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public class f implements v12.d, v12.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f130874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f130875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f130876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f130877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBaseUser f130878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IBaseUser f130879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h1 f130880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f130881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f130882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j3 f130883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f130884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f130885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f130886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f130887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f130888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f130889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f130890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f130891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f130892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f130893t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f130894u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f130895v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f130896w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<Integer, Long> f130897x;

    public static final class a {
    }

    static {
    }

    @Override // v12.d
    public final String a() {
        return null;
    }

    @Override // v12.c
    public final boolean c() {
        return false;
    }

    @Override // v12.d
    public final boolean d() {
        return false;
    }

    @Override // v12.d
    public final String f() {
        return null;
    }

    @Override // v12.c
    public final String getInteractGiftInfo() {
        return null;
    }

    @Override // v12.d
    public final boolean isLocal() {
        return false;
    }

    public final long g() {
        h1 r100 = this.f130880g;
        if (r100 == null) goto L5;
        int r101 = r100.getDiamondCount();
    L7:
        return r101;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // v12.d
    public final String getGiftInfo() {
        return "giftEnd: false ; comboCount: " + this.f130888o + " ; groupId: " + this.f130890q + " ; groupCount: " + this.f130889p;
    }

    public final String h() {
        long r100 = 0;
        if (this.f130874a != r100) goto L17;
        i12.e r101 = i12.o.b();
        GiftContext r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.android.scope.m.f163449e.getClass();
        com.bytedance.android.scope.o r103 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r101).a(Reflection.getOrCreateKotlinClass(GiftKmpInRoomService.class));
    L8:
        GiftKmpInRoomService r104 = (GiftKmpInRoomService) r103;
        if (r104 == null) goto L11;
        r102 = r104.bl();
    L11:
        if (r102 == null) goto L15;
        com.bytedance.live.datacontext.m<Long> r105 = r102.getBigGiftKeyCount();
        if (r105 == null) goto L15;
        r100 = r105.getValue().longValue() + 1;
        r105.setValue(Long.valueOf(r100));
    L15:
        this.f130874a = r100;
        goto L17
    L7:
        r103 = null;
    L17:
        return String.valueOf(this.f130874a);
    }

    public f() {
        long r100 = 0;
        this.f130874a = r100;
        this.f130876c = r100;
        this.f130881h = r100;
        this.f130884k = r100;
        this.f130885l = new ArrayList();
        this.f130886m = r100;
        this.f130887n = "";
        this.f130888o = r100;
        this.f130889p = r100;
        this.f130890q = r100;
        this.f130891r = "";
        this.f130893t = this.f130881h;
        this.f130895v = 1;
        this.f130897x = new LinkedHashMap();
    }

    @Override // v12.c
    public final String b() {
        return this.f130882i;
    }

    @Override // v12.d
    public final long e() {
        return this.f130888o;
    }

    @Override // v12.d
    public final long getAssetId() {
        return this.f130893t;
    }

    @Override // v12.d
    public final String getDescription() {
        return this.f130892s;
    }

    @Override // v12.c
    public final long getEffectId() {
        return this.f130881h;
    }

    @Override // v12.c
    public final IBaseUser getFromUser() {
        return this.f130878e;
    }

    @Override // v12.d
    public final String getFromUserId() {
        return this.f130891r;
    }

    @Override // v12.d
    public final long getGiftId() {
        return this.f130876c;
    }

    @Override // v12.d
    public final long getGroupCount() {
        return this.f130889p;
    }

    @Override // v12.d
    public final long getGroupId() {
        return this.f130890q;
    }

    @Override // v12.d
    public final String getLogId() {
        return this.f130887n;
    }

    @Override // v12.d
    public final long getMsgId() {
        return this.f130875b;
    }

    @Override // v12.c
    public final int getPriority() {
        return this.f130896w;
    }

    @Override // v12.c
    public final long getRepeatCount() {
        return this.f130895v;
    }

    @Override // v12.d
    public final IBaseUser getToUser() {
        return this.f130879f;
    }

    @Override // v12.d
    public final String getTraceId() {
        return this.f130894u;
    }
}
