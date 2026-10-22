package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/GXBackdropFilter;", "", "()V", "Blur", "Companion", "None", "Lcom/alibaba/gaiax/template/GXBackdropFilter$Blur;", "Lcom/alibaba/gaiax/template/GXBackdropFilter$None;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class GXBackdropFilter {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/alibaba/gaiax/template/GXBackdropFilter$Blur;", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Blur extends GXBackdropFilter {
        public static final Blur INSTANCE = null;

        static {
            INSTANCE = new Blur();
        }

        private Blur() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/template/GXBackdropFilter$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "backdropFilter", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXBackdropFilter create(String r100) {
            Intrinsics.checkNotNullParameter(r100, "backdropFilter");
            if (Intrinsics.areEqual(r100, "none") == false) goto L7;
            return None.INSTANCE;
        L7:
            if (StringsKt.contains$default(r100, "blur", false, 2, null) == true) goto L9;
            return null;
        L9:
            return Blur.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/alibaba/gaiax/template/GXBackdropFilter$None;", "Lcom/alibaba/gaiax/template/GXBackdropFilter;", "()V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class None extends GXBackdropFilter {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
            super(null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private GXBackdropFilter() {
    }

    public /* synthetic */ GXBackdropFilter(DefaultConstructorMarker r100) {
        this();
    }
}
