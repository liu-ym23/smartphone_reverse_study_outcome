package com.bytedance.android.anniex.ability.service;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/AccountAuthType;", "", "", "value", "I", "getValue", "()I", "Douyin", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AccountAuthType extends Enum<AccountAuthType> {
    public static final AccountAuthType Douyin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountAuthType[] f40240a = null;
    private final int value;

    public static AccountAuthType valueOf(String r100) {
        return (AccountAuthType) a.a(AccountAuthType.class, r100);
    }

    public static AccountAuthType[] values() {
        return (AccountAuthType[]) f40240a.clone();
    }

    static {
        AccountAuthType r100 = new AccountAuthType();
        Douyin = r100;
        f40240a = new AccountAuthType[]{r100};
    }

    public AccountAuthType() {
        super("Douyin", 0);
        this.value = 11;
    }

    public final int getValue() {
        return this.value;
    }
}
