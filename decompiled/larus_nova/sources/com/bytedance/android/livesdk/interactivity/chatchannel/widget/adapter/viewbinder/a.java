package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f134597a = null;

    static {
        int[] r100 = new int[ChannelLinkUserInfo.ChannelUserRole.values().length];
        f134597a = r100;
        r100[ChannelLinkUserInfo.ChannelUserRole.Audience.ordinal()] = 1;
        r100[ChannelLinkUserInfo.ChannelUserRole.Guest.ordinal()] = 2;
        r100[ChannelLinkUserInfo.ChannelUserRole.LinkApplicant.ordinal()] = 3;
        r100[ChannelLinkUserInfo.ChannelUserRole.LinkInvitee.ordinal()] = 4;
        r100[ChannelLinkUserInfo.ChannelUserRole.GuestApplicant.ordinal()] = 5;
    }
}
