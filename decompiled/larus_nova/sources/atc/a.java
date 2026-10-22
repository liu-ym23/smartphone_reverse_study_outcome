package atc;

import androidx.core.util.PatternsCompat;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import msc.o;

/* JADX INFO: loaded from: classes41.dex */
public class a extends lsc.a {

    /* JADX INFO: renamed from: atc.a$a, reason: collision with other inner class name */
    public static class C0229a implements o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f16297a = null;

        /* JADX INFO: renamed from: atc.a$a$a, reason: collision with other inner class name */
        public static final class C0230a {
        }

        public C0229a() {
        }

        static {
            Pattern r100 = PatternsCompat.IP_ADDRESS;
            if (r100 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            f16297a = PatternProtector.compile("(https?:\\/\\/)?([\\da-zA-Z@]+(\\.[-\\da-zA-Z@:]+)*\\.([a-zA-Z]{2,6})|" + r100 + ")(:\\d+)?(\\/[\\da-zA-Z-%\\$.~:_()+!]*)*(\\?[\\da-zA-Z-@%.&()=+!{}|;^_]*)?(#[\\da-zA-Z-@%.&()=+!{}|;^_]*)?");
        }
    }

    public a() {
    }
}
