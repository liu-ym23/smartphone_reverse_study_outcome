package com.stepos.ability.manager.discovery;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/manager/discovery/AbilityUploadState;", "", "manager_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityUploadState {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AbilityUploadState[] f3141a;

    static {
        AbilityUploadState[] abilityUploadStateArr = {new AbilityUploadState("UNKNOWN", 0), new AbilityUploadState("UPLOADING", 1), new AbilityUploadState("UPLOADED", 2), new AbilityUploadState("FAILED", 3)};
        f3141a = abilityUploadStateArr;
        kotlin.enums.a.a(abilityUploadStateArr);
    }

    public static AbilityUploadState valueOf(String str) {
        return (AbilityUploadState) Enum.valueOf(AbilityUploadState.class, str);
    }

    public static AbilityUploadState[] values() {
        return (AbilityUploadState[]) f3141a.clone();
    }
}
