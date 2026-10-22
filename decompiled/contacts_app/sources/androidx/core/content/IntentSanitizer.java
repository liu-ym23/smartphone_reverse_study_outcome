package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Api15Impl {
        private Api15Impl() {
        }

        static void setSelector(Intent r0, Intent r1) {
            r0.setSelector(r1);
        }

        static Intent getSelector(Intent r0) {
            return r0.getSelector();
        }
    }

    private static class Api16Impl {

        private static class Api31Impl {
            private Api31Impl() {
            }

            static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
                if (r3.getHtmlText() == null) goto L5;
            L8:
                r4.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
                return;
            L5:
                if (r3.getIntent() != null) goto L8;
                if (r3.getTextLinks() != null) goto L8;
            }
        }

        private Api16Impl() {
        }

        static void sanitizeClipData(Intent r7, Intent r8, Predicate<ClipData> r9, boolean r10, Predicate<Uri> r11, Consumer<String> r12) {
            ClipData r13 = r7.getClipData();
            if (r13 != null) goto L5;
            return;
        L5:
            if (r9 != null) goto L7;
        L9:
            int r0 = 0;
            ClipData r1 = null;
        L11:
            if (r0 >= r13.getItemCount()) goto L38;
            ClipData.Item r2 = r13.getItemAt(r0);
            Api31Impl.checkOtherMembers(r0, r2, r12);
            if (r10 == false) goto L16;
            CharSequence r3 = r2.getText();
        L20:
            if (r11 != null) goto L25;
            if (r2.getUri() == null) goto L30;
            r12.accept("Item URI is not allowed. Item position: " + r0 + ". URI: " + r2.getUri());
        L30:
            Uri r4 = null;
        L32:
            if (r3 != null) goto L34;
            if (r4 != null) goto L34;
        L37:
            r0 = r0 + 1;
        L34:
            if (r1 != null) goto L36;
            r1 = new ClipData(r13.getDescription(), new ClipData.Item(r3, null, r4));
            goto L37
        L36:
            r1.addItem(new ClipData.Item(r3, null, r4));
            goto L37
        L25:
            if (r2.getUri() != null) goto L27;
        L31:
            r4 = r2.getUri();
            goto L32
        L27:
            if (r11.test(r2.getUri()) == true) goto L31;
            r12.accept("Item URI is not allowed. Item position: " + r0 + ". URI: " + r2.getUri());
            goto L30
        L16:
            if (r2.getText() == null) goto L18;
            r12.accept("Item text cannot contain value. Item position: " + r0 + ". Text: " + r2.getText());
        L18:
            r3 = null;
            goto L20
        L38:
            if (r1 == null) goto L46;
            r8.setClipData(r1);
            return;
        L46:
            return;
        L7:
            if (r9.test(r13) == false) goto L9;
            r8.setClipData(r13);
        }

        private static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
            if (r3.getHtmlText() == null) goto L5;
        L6:
            r4.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
            return;
        L5:
            if (r3.getIntent() != null) goto L6;
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static Intent setIdentifier(Intent r0, String r1) {
            return r0.setIdentifier(r1);
        }

        static String getIdentifier(Intent r0) {
            return r0.getIdentifier();
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

        /* JADX INFO: renamed from: $r8$lambda$f9aU52V4hLVPTW2v-TcMiSk5YDc, reason: not valid java name */
        public static /* synthetic */ boolean m18$r8$lambda$f9aU52V4hLVPTW2vTcMiSk5YDc(ComponentName r0, Object r1) {
            return r0.equals(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$yzjFOqRUGseo4jtNtyZsqFTIwRc(String r0, Object r1) {
            return r0.equals(r1);
        }

        static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName r0) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowExtra$12(Object r0) {
            return true;
        }

        static /* synthetic */ boolean lambda$allowExtra$14(Object r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$0(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$1(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$2(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$3(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$4(String r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$5(ComponentName r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$6(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean lambda$new$7(ClipData r0) {
            return false;
        }

        public Builder() {
            this.mAllowedActions = new IntentSanitizer$Builder$$ExternalSyntheticLambda11();
            this.mAllowedData = new IntentSanitizer$Builder$$ExternalSyntheticLambda12();
            this.mAllowedTypes = new IntentSanitizer$Builder$$ExternalSyntheticLambda13();
            this.mAllowedCategories = new IntentSanitizer$Builder$$ExternalSyntheticLambda14();
            this.mAllowedPackages = new IntentSanitizer$Builder$$ExternalSyntheticLambda15();
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda16();
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = new IntentSanitizer$Builder$$ExternalSyntheticLambda17();
            this.mAllowedClipData = new IntentSanitizer$Builder$$ExternalSyntheticLambda18();
        }

        public Builder allowFlags(int r2) {
            this.mAllowedFlags = r2 | this.mAllowedFlags;
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

        public Builder allowAction(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            allowAction(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(r2));
            return this;
        }

        public Builder allowAction(Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedActions = this.mAllowedActions.or(r2);
            return this;
        }

        public Builder allowDataWithAuthority(final String r2) {
            Preconditions.checkNotNull(r2);
            allowData(new IntentSanitizer$Builder$$ExternalSyntheticLambda7(r2));
            return this;
        }

        static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        public Builder allowData(Predicate<Uri> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedData = this.mAllowedData.or(r2);
            return this;
        }

        public Builder allowType(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowType(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(r2));
        }

        public Builder allowType(Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedTypes = this.mAllowedTypes.or(r2);
            return this;
        }

        public Builder allowCategory(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowCategory(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(r2));
        }

        public Builder allowCategory(Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedCategories = this.mAllowedCategories.or(r2);
            return this;
        }

        public Builder allowPackage(String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowPackage(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(r2));
        }

        public Builder allowPackage(Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedPackages = this.mAllowedPackages.or(r2);
            return this;
        }

        public Builder allowComponent(final ComponentName r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda9(r2));
        }

        public Builder allowComponent(Predicate<ComponentName> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r2);
            return this;
        }

        public Builder allowComponentWithPackage(final String r2) {
            Preconditions.checkNotNull(r2);
            return allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda6(r2));
        }

        static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String r0, ComponentName r1) {
            return r0.equals(r1.getPackageName());
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda4();
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowClipDataUriWithAuthority(final String r2) {
            Preconditions.checkNotNull(r2);
            return allowClipDataUri(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(r2));
        }

        static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        public Builder allowClipDataUri(Predicate<Uri> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r2);
            return this;
        }

        public Builder allowClipData(Predicate<ClipData> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedClipData = this.mAllowedClipData.or(r2);
            return this;
        }

        public Builder allowExtra(String r2, Class<?> r3) {
            return allowExtra(r2, r3, new IntentSanitizer$Builder$$ExternalSyntheticLambda10());
        }

        public <T> Builder allowExtra(String r2, final Class<T> r3, final Predicate<T> r4) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Preconditions.checkNotNull(r4);
            return allowExtra(r2, new IntentSanitizer$Builder$$ExternalSyntheticLambda5(r3, r4));
        }

        static /* synthetic */ boolean lambda$allowExtra$13(Class r1, Predicate r2, Object r3) {
            if (r1.isInstance(r3) == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.test(r1.cast(r3)) == false) goto L7;
            return true;
        }

        public Builder allowExtra(String r2, Predicate<Object> r3) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Predicate<Object> r0 = this.mAllowedExtras.get(r2);
            if (r0 != null) goto L5;
            r0 = new IntentSanitizer$Builder$$ExternalSyntheticLambda0();
        L5:
            Predicate<Object> r4 = r0.or(r3);
            this.mAllowedExtras.put(r2, r4);
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(final String r3) {
            Preconditions.checkNotNull(r3);
            allowExtra("android.intent.extra.STREAM", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda3(r3));
            return this;
        }

        static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        public Builder allowExtraStream(Predicate<Uri> r3) {
            allowExtra("android.intent.extra.STREAM", Uri.class, r3);
            return this;
        }

        public Builder allowExtraOutput(final String r3) {
            allowExtra("output", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda8(r3));
            return this;
        }

        static /* synthetic */ boolean lambda$allowExtraOutput$16(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        public Builder allowExtraOutput(Predicate<Uri> r3) {
            allowExtra("output", Uri.class, r3);
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

        public IntentSanitizer build() {
            boolean r0 = this.mAllowAnyComponent;
            if (r0 == true) goto L5;
        L6:
            if (r0 == false) goto L8;
        L12:
            IntentSanitizer r1 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r1, this.mAllowedFlags);
            IntentSanitizer.access$202(r1, this.mAllowedActions);
            IntentSanitizer.access$302(r1, this.mAllowedData);
            IntentSanitizer.access$402(r1, this.mAllowedTypes);
            IntentSanitizer.access$502(r1, this.mAllowedCategories);
            IntentSanitizer.access$602(r1, this.mAllowedPackages);
            IntentSanitizer.access$702(r1, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r1, this.mAllowedComponents);
            IntentSanitizer.access$902(r1, this.mAllowedExtras);
            IntentSanitizer.access$1002(r1, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r1, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r1, this.mAllowedClipData);
            IntentSanitizer.access$1302(r1, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r1, this.mAllowSelector);
            IntentSanitizer.access$1502(r1, this.mAllowSourceBounds);
            return r1;
        L8:
            if (this.mAllowSomeComponents == true) goto L12;
        L11:
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        L5:
            if (this.mAllowSomeComponents == true) goto L11;
            goto L6
        }
    }

    static /* synthetic */ void lambda$sanitizeByFiltering$0(String r0) {
    }

    /* synthetic */ IntentSanitizer(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$1002(IntentSanitizer r0, boolean r1) {
        r0.mAllowClipDataText = r1;
        return r1;
    }

    static /* synthetic */ int access$102(IntentSanitizer r0, int r1) {
        r0.mAllowedFlags = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$1102(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedClipDataUri = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$1202(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedClipData = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1302(IntentSanitizer r0, boolean r1) {
        r0.mAllowIdentifier = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1402(IntentSanitizer r0, boolean r1) {
        r0.mAllowSelector = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1502(IntentSanitizer r0, boolean r1) {
        r0.mAllowSourceBounds = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$202(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedActions = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$302(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedData = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$402(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedTypes = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$502(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedCategories = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$602(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedPackages = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(IntentSanitizer r0, boolean r1) {
        r0.mAllowAnyComponent = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$802(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedComponents = r1;
        return r1;
    }

    static /* synthetic */ Map access$902(IntentSanitizer r0, Map r1) {
        r0.mAllowedExtras = r1;
        return r1;
    }

    private IntentSanitizer() {
    }

    public Intent sanitizeByFiltering(Intent r2) {
        return sanitize(r2, new IntentSanitizer$$ExternalSyntheticLambda0());
    }

    public Intent sanitizeByThrowing(Intent r2) {
        return sanitize(r2, new IntentSanitizer$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ void lambda$sanitizeByThrowing$1(String r1) {
        throw new SecurityException(r1);
    }

    public Intent sanitize(Intent r8, Consumer<String> r9) {
        Intent r6 = new Intent();
        ComponentName r0 = r8.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r0 != null) goto L6;
    L7:
        r6.setComponent(r0);
    L9:
        String r1 = r8.getPackage();
        if (r1 != null) goto L12;
    L15:
        r6.setPackage(r1);
    L16:
        int r2 = this.mAllowedFlags | r8.getFlags();
        int r3 = this.mAllowedFlags;
        if (r2 != r3) goto L19;
        r6.setFlags(r8.getFlags());
    L20:
        String r4 = r8.getAction();
        if (r4 != null) goto L23;
    L26:
        r6.setAction(r4);
    L27:
        Uri r5 = r8.getData();
        if (r5 != null) goto L30;
    L33:
        r6.setData(r5);
    L34:
        String r7 = r8.getType();
        if (r7 != null) goto L37;
    L40:
        r6.setDataAndType(r6.getData(), r7);
    L41:
        Set<String> r10 = r8.getCategories();
        if (r10 == null) goto L50;
        Iterator<String> r11 = r10.iterator();
    L45:
        if (r11.hasNext() == false) goto L50;
        String r12 = r11.next();
        if (this.mAllowedCategories.test(r12) == true) goto L48;
        r9.accept("Category is not allowed: " + r12);
        goto L45
    L48:
        r6.addCategory(r12);
    L50:
        Bundle r13 = r8.getExtras();
        if (r13 == null) goto L71;
        Iterator<String> r14 = r13.keySet().iterator();
    L54:
        if (r14.hasNext() == false) goto L71;
        String r15 = r14.next();
        if (r15.equals("android.intent.extra.STREAM") == false) goto L61;
        if ((this.mAllowedFlags & 1) != 0) goto L61;
        r9.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
    L61:
        if (r15.equals("output") == false) goto L65;
        if (((~this.mAllowedFlags) & 3) == 0) goto L65;
        r9.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
    L65:
        Object r16 = r13.get(r15);
        Predicate<Object> r17 = this.mAllowedExtras.get(r15);
        if (r17 == null) goto L70;
        if (r17.test(r16) == false) goto L70;
        putExtra(r6, r15, r16);
    L70:
        r9.accept("Extra is not allowed. Key: " + r15 + ". Value: " + r16);
    L71:
        Api16Impl.sanitizeClipData(r8, r6, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r9);
        if (this.mAllowIdentifier == false) goto L75;
        Api29Impl.setIdentifier(r6, Api29Impl.getIdentifier(r8));
    L78:
        if (this.mAllowSelector == false) goto L81;
        Api15Impl.setSelector(r6, Api15Impl.getSelector(r8));
    L84:
        if (this.mAllowSourceBounds == false) goto L87;
        r6.setSourceBounds(r8.getSourceBounds());
    L89:
        return r6;
    L87:
        if (r8.getSourceBounds() == null) goto L89;
        r9.accept("SourceBounds is not allowed: " + r8.getSourceBounds());
        goto L89
    L81:
        if (Api15Impl.getSelector(r8) == null) goto L84;
        r9.accept("Selector is not allowed: " + Api15Impl.getSelector(r8));
        goto L84
    L75:
        if (Api29Impl.getIdentifier(r8) == null) goto L78;
        r9.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r8));
        goto L78
    L37:
        if (this.mAllowedTypes.test(r7) == true) goto L40;
        r9.accept("Type is not allowed: " + r7);
        goto L41
    L30:
        if (this.mAllowedData.test(r5) == true) goto L33;
        r9.accept("Data is not allowed: " + r5);
        goto L34
    L23:
        if (this.mAllowedActions.test(r4) == true) goto L26;
        r9.accept("Action is not allowed: " + r4);
        goto L27
    L19:
        r6.setFlags(r8.getFlags() & r3);
        r9.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r8.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r1) == true) goto L15;
        r9.accept("Package is not allowed: " + r1);
    L6:
        if (this.mAllowedComponents.test(r0) == true) goto L7;
        r9.accept("Component is not allowed: " + r0);
        r6.setComponent(new ComponentName("android", "java.lang.Void"));
        goto L9
    }

    private void putExtra(Intent r1, String r2, Object r3) {
        if (r3 != null) goto L5;
        r1.getExtras().putString(r2, null);
        return;
    L5:
        if ((r3 instanceof Parcelable) == false) goto L8;
        r1.putExtra(r2, (Parcelable) r3);
        return;
    L8:
        if ((r3 instanceof Parcelable[]) == false) goto L11;
        r1.putExtra(r2, (Parcelable[]) r3);
        return;
    L11:
        if ((r3 instanceof Serializable) == false) goto L15;
        r1.putExtra(r2, (Serializable) r3);
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r3.getClass());
    }
}
