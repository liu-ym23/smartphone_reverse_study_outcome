package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Element;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ModifierLocalProvider<T> extends Modifier.Element {

    /* JADX INFO: renamed from: androidx.compose.ui.modifier.ModifierLocalProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static /* synthetic */ boolean access$all$jd(ModifierLocalProvider r100, Function1 r101) {
            return Modifier.Element.CC.$default$all(r100, r101);
        }

        public static /* synthetic */ boolean access$any$jd(ModifierLocalProvider r100, Function1 r101) {
            return Modifier.Element.CC.$default$any(r100, r101);
        }

        public static /* synthetic */ Modifier access$then$jd(ModifierLocalProvider r100, Modifier r101) {
            return Modifier.CC.$default$then(r100, r101);
        }

        public static /* synthetic */ Object access$foldIn$jd(ModifierLocalProvider r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldIn(r100, r101, r102);
        }

        public static /* synthetic */ Object access$foldOut$jd(ModifierLocalProvider r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldOut(r100, r101, r102);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> boolean all(ModifierLocalProvider<T> r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$all$jd(r100, r101);
        }

        public static <T> boolean any(ModifierLocalProvider<T> r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$any$jd(r100, r101);
        }

        public static <T> Modifier then(ModifierLocalProvider<T> r100, Modifier r101) {
            return CC.access$then$jd(r100, r101);
        }

        public static <T, R> R foldIn(ModifierLocalProvider<T> r100, R r101, Function2<? super R, ? super Modifier.Element, ? extends R> r102) {
            return (R) CC.access$foldIn$jd(r100, r101, r102);
        }

        public static <T, R> R foldOut(ModifierLocalProvider<T> r100, R r101, Function2<? super Modifier.Element, ? super R, ? extends R> r102) {
            return (R) CC.access$foldOut$jd(r100, r101, r102);
        }
    }

    ProvidableModifierLocal<T> getKey();

    T getValue();
}
