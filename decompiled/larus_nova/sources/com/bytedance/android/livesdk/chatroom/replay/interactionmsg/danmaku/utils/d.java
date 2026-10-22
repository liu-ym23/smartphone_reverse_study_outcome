package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f109249a = null;

    static {
        f109249a = PatternProtector.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");
    }
}
