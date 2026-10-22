package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes17.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final Compat mCompat;

    public static final class Api31Impl {
        private Api31Impl() {
        }

        public static Pair<ContentInfo, ContentInfo> partition(ContentInfo r100, final Predicate<ClipData.Item> r101) {
            ClipData r102 = r100.getClip();
            if (r102.getItemCount() != 1) goto L12;
            boolean r103 = r101.test(r102.getItemAt(0));
            if (r103 == false) goto L7;
            ContentInfo r104 = r100;
        L8:
            if (r103 == false) goto L11;
            r100 = null;
        L11:
            return Pair.create(r104, r100);
        L7:
            r104 = null;
            goto L8
        L12:
            Objects.requireNonNull(r101);
            Pair<ClipData, ClipData> r105 = ContentInfoCompat.partition(r102, new a(r101));
            if (r105.first != null) goto L17;
            return Pair.create(null, r100);
        L17:
            if (r105.second != null) goto L21;
            return Pair.create(r100, null);
        L21:
            return Pair.create(new ContentInfo.Builder(r100).setClip((ClipData) r105.first).build(), new ContentInfo.Builder(r100).setClip((ClipData) r105.second).build());
        }
    }

    public static final class Builder {
        private final BuilderCompat mBuilderCompat;

        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        public Builder(ContentInfoCompat r100) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            this.mBuilderCompat = new BuilderCompat31Impl(r100);
            return;
        L5:
            this.mBuilderCompat = new BuilderCompatImpl(r100);
        }

        public Builder setClip(ClipData r100) {
            this.mBuilderCompat.setClip(r100);
            return this;
        }

        public Builder setExtras(Bundle r100) {
            this.mBuilderCompat.setExtras(r100);
            return this;
        }

        public Builder setFlags(int r100) {
            this.mBuilderCompat.setFlags(r100);
            return this;
        }

        public Builder setLinkUri(Uri r100) {
            this.mBuilderCompat.setLinkUri(r100);
            return this;
        }

        public Builder setSource(int r100) {
            this.mBuilderCompat.setSource(r100);
            return this;
        }

        public Builder(ClipData r100, int r101) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            this.mBuilderCompat = new BuilderCompat31Impl(r100, r101);
            return;
        L5:
            this.mBuilderCompat = new BuilderCompatImpl(r100, r101);
        }
    }

    public interface BuilderCompat {
        ContentInfoCompat build();

        void setClip(ClipData r100);

        void setExtras(Bundle r100);

        void setFlags(int r100);

        void setLinkUri(Uri r100);

        void setSource(int r100);
    }

    public static final class BuilderCompat31Impl implements BuilderCompat {
        private final ContentInfo.Builder mPlatformBuilder;

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        public BuilderCompat31Impl(ContentInfoCompat r100) {
            this.mPlatformBuilder = new ContentInfo.Builder(r100.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r100) {
            this.mPlatformBuilder.setClip(r100);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r100) {
            this.mPlatformBuilder.setExtras(r100);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r100) {
            this.mPlatformBuilder.setFlags(r100);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r100) {
            this.mPlatformBuilder.setLinkUri(r100);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r100) {
            this.mPlatformBuilder.setSource(r100);
        }

        public BuilderCompat31Impl(ClipData r100, int r101) {
            this.mPlatformBuilder = new ContentInfo.Builder(r100, r101);
        }
    }

    public static final class BuilderCompatImpl implements BuilderCompat {
        ClipData mClip;
        Bundle mExtras;
        int mFlags;
        Uri mLinkUri;
        int mSource;

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public BuilderCompatImpl(ContentInfoCompat r100) {
            this.mClip = r100.getClip();
            this.mSource = r100.getSource();
            this.mFlags = r100.getFlags();
            this.mLinkUri = r100.getLinkUri();
            this.mExtras = r100.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r100) {
            this.mClip = r100;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r100) {
            this.mExtras = r100;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r100) {
            this.mFlags = r100;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r100) {
            this.mLinkUri = r100;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r100) {
            this.mSource = r100;
        }

        public BuilderCompatImpl(ClipData r100, int r101) {
            this.mClip = r100;
            this.mSource = r101;
        }
    }

    public interface Compat {
        ClipData getClip();

        Bundle getExtras();

        int getFlags();

        Uri getLinkUri();

        int getSource();

        ContentInfo getWrapped();
    }

    public static final class Compat31Impl implements Compat {
        private final ContentInfo mWrapped;

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mWrapped.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + com.alipay.sdk.m.u.i.f25855d;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        public Compat31Impl(ContentInfo r100) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(r100);
        }
    }

    public static final class CompatImpl implements Compat {
        private final ClipData mClip;
        private final Bundle mExtras;
        private final int mFlags;
        private final Uri mLinkUri;
        private final int mSource;

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("ContentInfoCompat{clip=");
            r100.append(this.mClip.getDescription());
            r100.append(", source=");
            r100.append(ContentInfoCompat.sourceToString(this.mSource));
            r100.append(", flags=");
            r100.append(ContentInfoCompat.flagsToString(this.mFlags));
            String r101 = "";
            if (this.mLinkUri != null) goto L5;
            String r102 = "";
        L6:
            r100.append(r102);
            if (this.mExtras == null) goto L10;
            r101 = ", hasExtras";
        L10:
            r100.append(r101);
            r100.append(com.alipay.sdk.m.u.i.f25855d);
            return r100.toString();
        L5:
            r102 = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            goto L6
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        public CompatImpl(BuilderCompatImpl r100) {
            this.mClip = (ClipData) Preconditions.checkNotNull(r100.mClip);
            this.mSource = Preconditions.checkArgumentInRange(r100.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(r100.mFlags, 1);
            this.mLinkUri = r100.mLinkUri;
            this.mExtras = r100.mExtras;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    public ContentInfo toContentInfo() {
        ContentInfo r100 = this.mCompat.getWrapped();
        Objects.requireNonNull(r100);
        return r100;
    }

    public String toString() {
        return this.mCompat.toString();
    }

    public ContentInfoCompat(Compat r100) {
        this.mCompat = r100;
    }

    public static String flagsToString(int r100) {
        if ((r100 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r100);
    }

    public static String sourceToString(int r100) {
        if (r100 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r100 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r100 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r100 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r100 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r100 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r100);
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo r100) {
        return new ContentInfoCompat(new Compat31Impl(r100));
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.Predicate<ClipData.Item> r100) {
        ClipData r101 = this.mCompat.getClip();
        ContentInfoCompat r102 = null;
        if (r101.getItemCount() != 1) goto L13;
        boolean r103 = r100.test(r101.getItemAt(0));
        if (r103 == false) goto L7;
        ContentInfoCompat r104 = this;
    L8:
        if (r103 == true) goto L12;
        r102 = this;
    L12:
        return Pair.create(r104, r102);
    L7:
        r104 = null;
        goto L8
    L13:
        Pair<ClipData, ClipData> r105 = partition(r101, r100);
        if (r105.first != null) goto L18;
        return Pair.create(null, this);
    L18:
        if (r105.second != null) goto L22;
        return Pair.create(this, null);
    L22:
        return Pair.create(new Builder(this).setClip((ClipData) r105.first).build(), new Builder(this).setClip((ClipData) r105.second).build());
    }

    public static ClipData buildClipData(ClipDescription r100, List<ClipData.Item> r101) {
        ClipData r102 = new ClipData(new ClipDescription(r100), (ClipData.Item) ListProtector.get(r101, 0));
        int r103 = 1;
    L4:
        if (r103 >= r101.size()) goto L6;
        r102.addItem((ClipData.Item) ListProtector.get(r101, r103));
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public static Pair<ClipData, ClipData> partition(ClipData r100, androidx.core.util.Predicate<ClipData.Item> r101) {
        int r102 = 0;
        ArrayList r103 = null;
        ArrayList r104 = null;
    L4:
        if (r102 >= r100.getItemCount()) goto L14;
        ClipData.Item r105 = r100.getItemAt(r102);
        if (r101.test(r105) == false) goto L10;
        if (r103 != null) goto L9;
        r103 = new ArrayList();
    L9:
        r103.add(r105);
    L13:
        r102 = r102 + 1;
        goto L4
    L10:
        if (r104 != null) goto L12;
        r104 = new ArrayList();
    L12:
        r104.add(r105);
        goto L13
    L14:
        if (r103 == null) goto L16;
        if (r104 != null) goto L21;
        return Pair.create(r100, null);
    L21:
        return Pair.create(buildClipData(r100.getDescription(), r103), buildClipData(r100.getDescription(), r104));
    L16:
        return Pair.create(null, r100);
    }

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo r100, Predicate<ClipData.Item> r101) {
        return Api31Impl.partition(r100, r101);
    }
}
