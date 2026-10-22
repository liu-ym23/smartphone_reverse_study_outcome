package com.android.ttcjpaysdk.base.h5.xelement.keyboard;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import ie4.b;
import ie4.c;
import ie4.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/xelement/keyboard/KeyBoardFactory;", "Lie4/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lhe4/c;", "Lie4/b;", "Lie4/d;", "create", "<init>", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class KeyBoardFactory implements c {
    public static final Companion Companion = null;
    private static final String TAG = "KeyBoardFactory";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/xelement/keyboard/KeyBoardFactory$Companion;", "", "()V", "TAG", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KeyBoardFactory() {
    }

    @Override // he4.d
    public he4.c<b, d> create(final Context r100) {
        return new AnonymousClass1(r100);
    }
}
