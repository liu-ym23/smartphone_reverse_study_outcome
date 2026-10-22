package com.networknt.schema.i18n;

/* loaded from: classes2.dex */
public class DefaultMessageSource {
    public static final String BUNDLE_BASE_NAME = "jsv-messages";

    public static class Holder {
        private static final MessageSource INSTANCE = new ResourceBundleMessageSource(DefaultMessageSource.BUNDLE_BASE_NAME);
    }

    public static MessageSource getInstance() {
        return Holder.INSTANCE;
    }
}
