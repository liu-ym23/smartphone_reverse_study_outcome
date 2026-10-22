package com.bytedance.android.livesdkapi.depend.constant;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class MessageConstants extends CommonConstants {
    public static final String BUNDLE_FROM_NOTIFICATION = "from_notification";
    public static final int TYPE_REGISTER_FROM_HEART_BEAT = 4;
    public static final int TYPE_REGISTER_FROM_INIT = 2;
    public static final int TYPE_REGISTER_FROM_RECEIVER = 1;
    public static final int TYPE_REGISTER_FROM_SCHEDULED = 3;
    public static final Set<Integer> TYPE_REGISTER_SET = null;

    static {
        HashSet r100 = new HashSet();
        TYPE_REGISTER_SET = r100;
        r100.add(1);
        r100.add(2);
        r100.add(3);
        r100.add(4);
    }

    public MessageConstants() {
    }
}
