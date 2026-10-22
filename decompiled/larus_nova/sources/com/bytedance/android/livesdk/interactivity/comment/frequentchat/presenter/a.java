package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f134905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f134906b = null;

    static {
        int[] r100 = new int[FrequentChatShowMode.values().length];
        f134905a = r100;
        FrequentChatShowMode r101 = FrequentChatShowMode.READ;
        r100[r101.ordinal()] = 1;
        FrequentChatShowMode r102 = FrequentChatShowMode.EDIT;
        r100[r102.ordinal()] = 2;
        FrequentChatShowMode r103 = FrequentChatShowMode.SORT;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[FrequentChatShowMode.values().length];
        f134906b = r104;
        r104[r102.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
