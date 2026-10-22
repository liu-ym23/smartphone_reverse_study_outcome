package android.view;

import D7.q;
import H4.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0003*\u00060\u0000j\u0002`\u00012\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\n\u001a\u00020\u0007*\u00060\u0000j\u0002`\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u0013\u001a\u00020\u0010*\u00060\u0000j\u0002`\u00012\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "other", "", "contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepEquals", "", "contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt", "(Landroid/os/Bundle;)I", "contentDeepHashCode", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "LC7/r;", "contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt", "(Landroid/os/Bundle;Ljava/lang/StringBuilder;Ljava/util/List;)V", "contentDeepToString", "savedstate_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateReaderKt")
/* renamed from: androidx.savedstate.SavedStateReaderKt__SavedStateReader_androidKt, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
final /* synthetic */ class Bundle {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(android.os.Bundle bundle, android.os.Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj != obj2 && !k.b(obj, obj2)) {
                if (obj != null && obj2 != null) {
                    if ((obj instanceof android.os.Bundle) && (obj2 instanceof android.os.Bundle)) {
                        if (!contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt((android.os.Bundle) obj, (android.os.Bundle) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                        if (!q.P((Object[]) obj, (Object[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                        if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                        if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                        if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                        if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                        if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                        if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                        if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                        if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            return false;
                        }
                    } else if (!obj.equals(obj2)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(android.os.Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        int iContentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = 1;
        while (it.hasNext()) {
            Object obj = bundle.get(it.next());
            iContentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt = (iContentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt * 31) + (obj instanceof android.os.Bundle ? contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt((android.os.Bundle) obj) : obj instanceof Object[] ? Arrays.deepHashCode((Object[]) obj) : obj instanceof byte[] ? Arrays.hashCode((byte[]) obj) : obj instanceof short[] ? Arrays.hashCode((short[]) obj) : obj instanceof int[] ? Arrays.hashCode((int[]) obj) : obj instanceof long[] ? Arrays.hashCode((long[]) obj) : obj instanceof float[] ? Arrays.hashCode((float[]) obj) : obj instanceof double[] ? Arrays.hashCode((double[]) obj) : obj instanceof char[] ? Arrays.hashCode((char[]) obj) : obj instanceof boolean[] ? Arrays.hashCode((boolean[]) obj) : obj != null ? obj.hashCode() : 0);
        }
        return iContentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(android.os.Bundle bundle, StringBuilder sb, List<android.os.Bundle> list) {
        if (list.contains(bundle)) {
            sb.append("[...]");
            return;
        }
        list.add(bundle);
        sb.append('[');
        int i = 0;
        for (String str : bundle.keySet()) {
            int i6 = i + 1;
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(str + '=');
            Object obj = bundle.get(str);
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof android.os.Bundle) {
                contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt((android.os.Bundle) obj, sb, list);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                if (length > 429496729) {
                    length = 429496729;
                }
                StringBuilder sb2 = new StringBuilder((length * 5) + 2);
                q.Q(objArr, sb2, new ArrayList());
                sb.append(sb2.toString());
            } else if (obj instanceof byte[]) {
                String string = Arrays.toString((byte[]) obj);
                k.e(string, "toString(...)");
                sb.append(string);
            } else if (obj instanceof short[]) {
                String string2 = Arrays.toString((short[]) obj);
                k.e(string2, "toString(...)");
                sb.append(string2);
            } else if (obj instanceof int[]) {
                String string3 = Arrays.toString((int[]) obj);
                k.e(string3, "toString(...)");
                sb.append(string3);
            } else if (obj instanceof long[]) {
                String string4 = Arrays.toString((long[]) obj);
                k.e(string4, "toString(...)");
                sb.append(string4);
            } else if (obj instanceof float[]) {
                String string5 = Arrays.toString((float[]) obj);
                k.e(string5, "toString(...)");
                sb.append(string5);
            } else if (obj instanceof double[]) {
                String string6 = Arrays.toString((double[]) obj);
                k.e(string6, "toString(...)");
                sb.append(string6);
            } else if (obj instanceof char[]) {
                String string7 = Arrays.toString((char[]) obj);
                k.e(string7, "toString(...)");
                sb.append(string7);
            } else if (obj instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) obj);
                k.e(string8, "toString(...)");
                sb.append(string8);
            } else {
                sb.append(obj.toString());
            }
            i = i6;
        }
        sb.append(']');
        list.remove(o.H(list));
    }
}
