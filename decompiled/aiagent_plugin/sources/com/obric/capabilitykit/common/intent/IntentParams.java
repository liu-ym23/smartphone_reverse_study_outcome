package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IntentParams extends Parcelable {

    public static final class a {
        public static IntentParams a(IntentParams r1, Object r2) {
            return (IntentParams) ZeusTransformUtils.wrapperContextForParams(r1, IntentParams.class, "com.obric.aiagent.plugin");
        }

        public static boolean a(IntentParams r2) {
            IntentParams r3 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r2, IntentParams.class, "com.obric.aiagent.plugin");
            return true;
        }

        public static String b(IntentParams r2) {
            IntentParams r3 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r2, IntentParams.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    String getSubActionValue();

    boolean isParamsCompleted();

    IntentParams mergeParams(Object r1);
}
