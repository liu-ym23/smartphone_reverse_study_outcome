package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    /* JADX INFO: renamed from: androidx.core.content.IntentSanitizer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static String getIdentifier(Intent r100) {
            return r100.getIdentifier();
        }

        public static Intent setIdentifier(Intent r100, String r101) {
            return r100.setIdentifier(r101);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static void checkOtherMembers(int r100, ClipData.Item r101, Consumer<String> r102) {
            if (r101.getHtmlText() == null) goto L5;
        L8:
            r102.accept("ClipData item at position " + r100 + " contains htmlText, textLinks or intent: " + r101);
            return;
        L5:
            if (r101.getIntent() != null) goto L8;
            if (r101.getTextLinks() != null) goto L8;
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions;
        private Predicate<String> mAllowedCategories;
        private Predicate<ClipData> mAllowedClipData;
        private Predicate<Uri> mAllowedClipDataUri;
        private Predicate<ComponentName> mAllowedComponents;
        private Predicate<Uri> mAllowedData;
        private Map<String, Predicate<Object>> mAllowedExtras;
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages;
        private Predicate<String> mAllowedTypes;

        public static /* synthetic */ boolean a(String r100) {
            return lambda$new$2(r100);
        }

        public static /* synthetic */ boolean b(Uri r100) {
            return lambda$new$6(r100);
        }

        public static /* synthetic */ boolean c(String r100, Uri r101) {
            return lambda$allowExtraOutput$16(r100, r101);
        }

        public static /* synthetic */ boolean d(ComponentName r100) {
            return lambda$allowAnyComponent$10(r100);
        }

        public static /* synthetic */ boolean e(String r100) {
            return lambda$new$0(r100);
        }

        public static /* synthetic */ boolean f(Object r100) {
            return lambda$allowExtra$14(r100);
        }

        public static /* synthetic */ boolean g(String r100, Uri r101) {
            return lambda$allowClipDataUriWithAuthority$11(r100, r101);
        }

        public static /* synthetic */ boolean h(String r100) {
            return lambda$new$4(r100);
        }

        public static /* synthetic */ boolean i(Uri r100) {
            return lambda$new$1(r100);
        }

        public static /* synthetic */ boolean j(String r100) {
            return lambda$new$3(r100);
        }

        public static /* synthetic */ boolean k(String r100, Uri r101) {
            return lambda$allowDataWithAuthority$8(r100, r101);
        }

        public static /* synthetic */ boolean l(Object r100) {
            return lambda$allowExtra$12(r100);
        }

        private static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName r100) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$12(Object r100) {
            return true;
        }

        private static /* synthetic */ boolean lambda$allowExtra$14(Object r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$0(String r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$1(Uri r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$2(String r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$3(String r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$4(String r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$5(ComponentName r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$6(Uri r100) {
            return false;
        }

        private static /* synthetic */ boolean lambda$new$7(ClipData r100) {
            return false;
        }

        public static /* synthetic */ boolean m(String r100, ComponentName r101) {
            return lambda$allowComponentWithPackage$9(r100, r101);
        }

        public static /* synthetic */ boolean n(String r100, Uri r101) {
            return lambda$allowExtraStreamUriWithAuthority$15(r100, r101);
        }

        public static /* synthetic */ boolean o(ComponentName r100) {
            return lambda$new$5(r100);
        }

        public static /* synthetic */ boolean p(Class r100, Predicate r101, Object r102) {
            return lambda$allowExtra$13(r100, r101, r102);
        }

        public static /* synthetic */ boolean q(ClipData r100) {
            return lambda$new$7(r100);
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new g();
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        public IntentSanitizer build() {
            boolean r100 = this.mAllowAnyComponent;
            if (r100 == true) goto L5;
        L6:
            if (r100 == false) goto L8;
        L12:
            IntentSanitizer r101 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r101, this.mAllowedFlags);
            IntentSanitizer.access$202(r101, this.mAllowedActions);
            IntentSanitizer.access$302(r101, this.mAllowedData);
            IntentSanitizer.access$402(r101, this.mAllowedTypes);
            IntentSanitizer.access$502(r101, this.mAllowedCategories);
            IntentSanitizer.access$602(r101, this.mAllowedPackages);
            IntentSanitizer.access$702(r101, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r101, this.mAllowedComponents);
            IntentSanitizer.access$902(r101, this.mAllowedExtras);
            IntentSanitizer.access$1002(r101, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r101, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r101, this.mAllowedClipData);
            IntentSanitizer.access$1302(r101, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r101, this.mAllowSelector);
            IntentSanitizer.access$1502(r101, this.mAllowSourceBounds);
            return r101;
        L8:
            if (this.mAllowSomeComponents == true) goto L12;
        L11:
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        L5:
            if (this.mAllowSomeComponents == true) goto L11;
            goto L6
        }

        public Builder() {
            this.mAllowedActions = new n();
            this.mAllowedData = new o();
            this.mAllowedTypes = new p();
            this.mAllowedCategories = new q();
            this.mAllowedPackages = new r();
            this.mAllowedComponents = new s();
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = new t();
            this.mAllowedClipData = new u();
        }

        public Builder allowAction(String r100) {
            Preconditions.checkNotNull(r100);
            Objects.requireNonNull(r100);
            allowAction(new e(r100));
            return this;
        }

        public Builder allowCategory(String r100) {
            Preconditions.checkNotNull(r100);
            Objects.requireNonNull(r100);
            return allowCategory(new e(r100));
        }

        public Builder allowClipData(Predicate<ClipData> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedClipData = this.mAllowedClipData.or(r100);
            return this;
        }

        public Builder allowClipDataUri(Predicate<Uri> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r100);
            return this;
        }

        public Builder allowClipDataUriWithAuthority(final String r100) {
            Preconditions.checkNotNull(r100);
            return allowClipDataUri(new d(r100));
        }

        public Builder allowComponent(final ComponentName r100) {
            Preconditions.checkNotNull(r100);
            Objects.requireNonNull(r100);
            return allowComponent(new l(r100));
        }

        public Builder allowComponentWithPackage(final String r100) {
            Preconditions.checkNotNull(r100);
            return allowComponent(new i(r100));
        }

        public Builder allowData(Predicate<Uri> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedData = this.mAllowedData.or(r100);
            return this;
        }

        public Builder allowDataWithAuthority(final String r100) {
            Preconditions.checkNotNull(r100);
            allowData(new j(r100));
            return this;
        }

        public Builder allowExtraOutput(final String r100) {
            allowExtra(BdpAppEventConstant.PARAMS_OUTPUT, Uri.class, new k(r100));
            return this;
        }

        public Builder allowExtraStream(Predicate<Uri> r100) {
            allowExtra("android.intent.extra.STREAM", Uri.class, r100);
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(final String r100) {
            Preconditions.checkNotNull(r100);
            allowExtra("android.intent.extra.STREAM", Uri.class, new f(r100));
            return this;
        }

        public Builder allowFlags(int r100) {
            this.mAllowedFlags = r100 | this.mAllowedFlags;
            return this;
        }

        public Builder allowPackage(String r100) {
            Preconditions.checkNotNull(r100);
            Objects.requireNonNull(r100);
            return allowPackage(new e(r100));
        }

        public Builder allowType(String r100) {
            Preconditions.checkNotNull(r100);
            Objects.requireNonNull(r100);
            return allowType(new e(r100));
        }

        public Builder allowAction(Predicate<String> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedActions = this.mAllowedActions.or(r100);
            return this;
        }

        public Builder allowCategory(Predicate<String> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedCategories = this.mAllowedCategories.or(r100);
            return this;
        }

        public Builder allowComponent(Predicate<ComponentName> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r100);
            return this;
        }

        public Builder allowExtraOutput(Predicate<Uri> r100) {
            allowExtra(BdpAppEventConstant.PARAMS_OUTPUT, Uri.class, r100);
            return this;
        }

        public Builder allowPackage(Predicate<String> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedPackages = this.mAllowedPackages.or(r100);
            return this;
        }

        public Builder allowType(Predicate<String> r100) {
            Preconditions.checkNotNull(r100);
            this.mAllowedTypes = this.mAllowedTypes.or(r100);
            return this;
        }

        private static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String r100, Uri r101) {
            return r100.equals(r101.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String r100, ComponentName r101) {
            return r100.equals(r101.getPackageName());
        }

        private static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String r100, Uri r101) {
            return r100.equals(r101.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtraOutput$16(String r100, Uri r101) {
            return r100.equals(r101.getAuthority());
        }

        private static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String r100, Uri r101) {
            return r100.equals(r101.getAuthority());
        }

        public Builder allowExtra(String r100, Predicate<Object> r101) {
            Preconditions.checkNotNull(r100);
            Preconditions.checkNotNull(r101);
            Predicate<Object> r102 = this.mAllowedExtras.get(r100);
            if (r102 != null) goto L5;
            r102 = new c();
        L5:
            Predicate<Object> r103 = r102.or(r101);
            this.mAllowedExtras.put(r100, r103);
            return this;
        }

        public Builder allowExtra(String r100, Class<?> r101) {
            return allowExtra(r100, r101, new m());
        }

        private static /* synthetic */ boolean lambda$allowExtra$13(Class r100, Predicate r101, Object r102) {
            if (r100.isInstance(r102) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.test(r100.cast(r102)) == false) goto L7;
            return true;
        }

        public <T> Builder allowExtra(String r100, final Class<T> r101, final Predicate<T> r102) {
            Preconditions.checkNotNull(r100);
            Preconditions.checkNotNull(r101);
            Preconditions.checkNotNull(r102);
            return allowExtra(r100, new h(r101, r102));
        }
    }

    public static /* synthetic */ void a(String r100) {
        lambda$sanitizeByThrowing$1(r100);
    }

    public static /* synthetic */ void b(String r100) {
        lambda$sanitizeByFiltering$0(r100);
    }

    private static /* synthetic */ void lambda$sanitizeByFiltering$0(String r100) {
    }

    private IntentSanitizer() {
    }

    public /* synthetic */ IntentSanitizer(AnonymousClass1 r100) {
        this();
    }

    private static /* synthetic */ void lambda$sanitizeByThrowing$1(String r100) {
        throw new SecurityException(r100);
    }

    public Intent sanitizeByFiltering(Intent r100) {
        return sanitize(r100, new a());
    }

    public Intent sanitizeByThrowing(Intent r100) {
        return sanitize(r100, new b());
    }

    public static /* synthetic */ boolean access$1002(IntentSanitizer r100, boolean r101) {
        r100.mAllowClipDataText = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(IntentSanitizer r100, int r101) {
        r100.mAllowedFlags = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$1102(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedClipDataUri = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$1202(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedClipData = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1302(IntentSanitizer r100, boolean r101) {
        r100.mAllowIdentifier = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1402(IntentSanitizer r100, boolean r101) {
        r100.mAllowSelector = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1502(IntentSanitizer r100, boolean r101) {
        r100.mAllowSourceBounds = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$202(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedActions = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$302(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedData = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$402(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedTypes = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$502(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedCategories = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$602(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedPackages = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(IntentSanitizer r100, boolean r101) {
        r100.mAllowAnyComponent = r101;
        return r101;
    }

    public static /* synthetic */ Predicate access$802(IntentSanitizer r100, Predicate r101) {
        r100.mAllowedComponents = r101;
        return r101;
    }

    public static /* synthetic */ Map access$902(IntentSanitizer r100, Map r101) {
        r100.mAllowedExtras = r101;
        return r101;
    }

    public Intent sanitize(Intent r100, Consumer<String> r101) {
        Intent r102 = new Intent();
        ComponentName r103 = r100.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r103 != null) goto L6;
    L7:
        r102.setComponent(r103);
    L9:
        String r104 = r100.getPackage();
        if (r104 != null) goto L12;
    L15:
        r102.setPackage(r104);
    L16:
        int r105 = this.mAllowedFlags | r100.getFlags();
        int r106 = this.mAllowedFlags;
        if (r105 != r106) goto L19;
        r102.setFlags(r100.getFlags());
    L20:
        String r107 = r100.getAction();
        if (r107 != null) goto L23;
    L26:
        r102.setAction(r107);
    L27:
        Uri r108 = r100.getData();
        if (r108 != null) goto L30;
    L33:
        r102.setData(r108);
    L34:
        String r109 = r100.getType();
        if (r109 != null) goto L37;
    L40:
        r102.setDataAndType(r102.getData(), r109);
    L41:
        Set<String> r110 = r100.getCategories();
        if (r110 == null) goto L50;
        Iterator<String> r111 = r110.iterator();
    L45:
        if (r111.hasNext() == false) goto L50;
        String r112 = r111.next();
        if (this.mAllowedCategories.test(r112) == true) goto L48;
        r101.accept("Category is not allowed: " + r112);
        goto L45
    L48:
        r102.addCategory(r112);
    L50:
        Bundle r113 = r100.getExtras();
        if (r113 == null) goto L71;
        Iterator<String> r114 = r113.keySet().iterator();
    L54:
        if (r114.hasNext() == false) goto L71;
        String r115 = r114.next();
        if (r115.equals("android.intent.extra.STREAM") == false) goto L61;
        if ((this.mAllowedFlags & 1) != 0) goto L61;
        r101.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
    L61:
        if (r115.equals(BdpAppEventConstant.PARAMS_OUTPUT) == false) goto L65;
        if (((~this.mAllowedFlags) & 3) == 0) goto L65;
        r101.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
    L65:
        Object r116 = r113.get(r115);
        Predicate<Object> r117 = this.mAllowedExtras.get(r115);
        if (r117 == null) goto L70;
        if (r117.test(r116) == false) goto L70;
        putExtra(r102, r115, r116);
    L70:
        r101.accept("Extra is not allowed. Key: " + r115 + ". Value: " + r116);
    L71:
        sanitizeClipData(r100, r102, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r101);
        if (Build.VERSION.SDK_INT < 29) goto L80;
        if (this.mAllowIdentifier == false) goto L77;
        Api29Impl.setIdentifier(r102, Api29Impl.getIdentifier(r100));
        goto L80
    L77:
        if (Api29Impl.getIdentifier(r100) == null) goto L80;
        r101.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r100));
    L80:
        if (this.mAllowSelector == false) goto L83;
        r102.setSelector(r100.getSelector());
    L86:
        if (this.mAllowSourceBounds == false) goto L89;
        r102.setSourceBounds(r100.getSourceBounds());
    L91:
        return r102;
    L89:
        if (r100.getSourceBounds() == null) goto L91;
        r101.accept("SourceBounds is not allowed: " + r100.getSourceBounds());
        goto L91
    L83:
        if (r100.getSelector() == null) goto L86;
        r101.accept("Selector is not allowed: " + r100.getSelector());
        goto L86
    L37:
        if (this.mAllowedTypes.test(r109) == true) goto L40;
        r101.accept("Type is not allowed: ".concat(r109));
        goto L41
    L30:
        if (this.mAllowedData.test(r108) == true) goto L33;
        r101.accept("Data is not allowed: " + r108);
        goto L34
    L23:
        if (this.mAllowedActions.test(r107) == true) goto L26;
        r101.accept("Action is not allowed: ".concat(r107));
        goto L27
    L19:
        r102.setFlags(r100.getFlags() & r106);
        r101.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r100.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r104) == true) goto L15;
        r101.accept("Package is not allowed: ".concat(r104));
    L6:
        if (this.mAllowedComponents.test(r103) == true) goto L7;
        r101.accept("Component is not allowed: " + r103);
        r102.setComponent(new ComponentName("android", "java.lang.Void"));
        goto L9
    }

    private static void checkOtherMembers(int r100, ClipData.Item r101, Consumer<String> r102) {
        if (r101.getHtmlText() == null) goto L5;
    L6:
        r102.accept("ClipData item at position " + r100 + " contains htmlText, textLinks or intent: " + r101);
        return;
    L5:
        if (r101.getIntent() != null) goto L6;
    }

    private void putExtra(Intent r100, String r101, Object r102) {
        if (r102 != null) goto L5;
        r100.getExtras().putString(r101, null);
        return;
    L5:
        if ((r102 instanceof Parcelable) == false) goto L8;
        r100.putExtra(r101, (Parcelable) r102);
        return;
    L8:
        if ((r102 instanceof Parcelable[]) == false) goto L11;
        r100.putExtra(r101, (Parcelable[]) r102);
        return;
    L11:
        if ((r102 instanceof Serializable) == false) goto L15;
        r100.putExtra(r101, (Serializable) r102);
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r102.getClass());
    }

    public static void sanitizeClipData(Intent r100, Intent r101, Predicate<ClipData> r102, boolean r110, Predicate<Uri> r111, Consumer<String> r112) {
        ClipData r103 = r100.getClipData();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
    L9:
        int r104 = 0;
        ClipData r105 = null;
    L11:
        if (r104 >= r103.getItemCount()) goto L41;
        ClipData.Item r106 = r103.getItemAt(r104);
        if (Build.VERSION.SDK_INT < 31) goto L15;
        Api31Impl.checkOtherMembers(r104, r106, r112);
    L16:
        if (r110 == false) goto L19;
        CharSequence r107 = r106.getText();
    L23:
        if (r111 != null) goto L28;
        if (r106.getUri() == null) goto L33;
        r112.accept("Item URI is not allowed. Item position: " + r104 + ". URI: " + r106.getUri());
    L33:
        Uri r108 = null;
    L35:
        if (r107 != null) goto L37;
        if (r108 != null) goto L37;
    L40:
        r104 = r104 + 1;
    L37:
        if (r105 != null) goto L39;
        r105 = new ClipData(r103.getDescription(), new ClipData.Item(r107, null, r108));
        goto L40
    L39:
        r105.addItem(new ClipData.Item(r107, null, r108));
        goto L40
    L28:
        if (r106.getUri() != null) goto L30;
    L34:
        r108 = r106.getUri();
        goto L35
    L30:
        if (r111.test(r106.getUri()) == true) goto L34;
        r112.accept("Item URI is not allowed. Item position: " + r104 + ". URI: " + r106.getUri());
        goto L33
    L19:
        if (r106.getText() == null) goto L21;
        r112.accept("Item text cannot contain value. Item position: " + r104 + ". Text: " + r106.getText());
    L21:
        r107 = null;
        goto L23
    L15:
        checkOtherMembers(r104, r106, r112);
        goto L16
    L41:
        if (r105 == null) goto L49;
        r101.setClipData(r105);
        return;
    L49:
        return;
    L7:
        if (r102.test(r103) == false) goto L9;
        r101.setClipData(r103);
    }
}
