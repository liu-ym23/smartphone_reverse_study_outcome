package com.stepos.aiengine.modelmanager;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrimaryBranch {

    /* renamed from: a, reason: collision with root package name */
    public static final PrimaryBranch f5891a;

    /* renamed from: b, reason: collision with root package name */
    public static final PrimaryBranch f5892b;

    /* renamed from: c, reason: collision with root package name */
    public static final PrimaryBranch f5893c;

    /* renamed from: d, reason: collision with root package name */
    public static final PrimaryBranch f5894d;

    /* renamed from: e, reason: collision with root package name */
    public static final PrimaryBranch f5895e;
    public static final /* synthetic */ PrimaryBranch[] h;

    static {
        PrimaryBranch primaryBranch = new PrimaryBranch("PAUSE", 0);
        f5891a = primaryBranch;
        PrimaryBranch primaryBranch2 = new PrimaryBranch("RESUME", 1);
        f5892b = primaryBranch2;
        PrimaryBranch primaryBranch3 = new PrimaryBranch("RETRY", 2);
        f5893c = primaryBranch3;
        PrimaryBranch primaryBranch4 = new PrimaryBranch("UPDATE", 3);
        f5894d = primaryBranch4;
        PrimaryBranch primaryBranch5 = new PrimaryBranch("DOWNLOAD", 4);
        f5895e = primaryBranch5;
        PrimaryBranch[] primaryBranchArr = {primaryBranch, primaryBranch2, primaryBranch3, primaryBranch4, primaryBranch5};
        h = primaryBranchArr;
        a.a(primaryBranchArr);
    }

    public PrimaryBranch() {
        throw null;
    }

    public static PrimaryBranch valueOf(String str) {
        return (PrimaryBranch) Enum.valueOf(PrimaryBranch.class, str);
    }

    public static PrimaryBranch[] values() {
        return (PrimaryBranch[]) h.clone();
    }
}
