package yc;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import yc.e;
import yc.h;

/* loaded from: classes5.dex */
public class c {

    @TargetApi(24)
    public static final class a extends c {
        @Override // yc.c
        public List<? extends e.a> a(Executor executor) {
            return Arrays.asList(new g(), new i(executor));
        }

        @Override // yc.c
        public List<? extends h.a> b() {
            return Collections.singletonList(new p());
        }
    }

    public List<? extends e.a> a(Executor executor) {
        return Collections.singletonList(new i(executor));
    }

    public List<? extends h.a> b() {
        return Collections.EMPTY_LIST;
    }
}
