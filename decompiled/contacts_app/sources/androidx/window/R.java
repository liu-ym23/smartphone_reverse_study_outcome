package androidx.window;

/* JADX INFO: loaded from: classes.dex */
public final class R {

    public static final class attr {
        public static final int activityAction = 0x7f040031;
        public static final int activityName = 0x7f040033;
        public static final int alwaysExpand = 0x7f040042;
        public static final int clearTop = 0x7f040110;
        public static final int finishPrimaryWithSecondary = 0x7f04025c;
        public static final int finishSecondaryWithPrimary = 0x7f04025d;
        public static final int placeholderActivityName = 0x7f0406d9;
        public static final int primaryActivityName = 0x7f040701;
        public static final int secondaryActivityAction = 0x7f040748;
        public static final int secondaryActivityName = 0x7f040749;
        public static final int splitLayoutDirection = 0x7f0407c2;
        public static final int splitMinSmallestWidth = 0x7f0407c3;
        public static final int splitMinWidth = 0x7f0407c4;
        public static final int splitRatio = 0x7f0407c5;

        private attr() {
        }
    }

    public static final class id {
        public static final int androidx_window_activity_scope = 0x7f0a00bb;
        public static final int locale = 0x7f0a04bc;
        public static final int ltr = 0x7f0a04c2;
        public static final int rtl = 0x7f0a0671;

        private id() {
        }
    }

    public static final class styleable {
        public static final int[] ActivityFilter = null;
        public static final int ActivityFilter_activityAction = 0x00000000;
        public static final int ActivityFilter_activityName = 0x00000001;
        public static final int[] ActivityRule = null;
        public static final int ActivityRule_alwaysExpand = 0x00000000;
        public static final int[] SplitPairFilter = null;
        public static final int SplitPairFilter_primaryActivityName = 0x00000000;
        public static final int SplitPairFilter_secondaryActivityAction = 0x00000001;
        public static final int SplitPairFilter_secondaryActivityName = 0x00000002;
        public static final int[] SplitPairRule = null;
        public static final int SplitPairRule_clearTop = 0x00000000;
        public static final int SplitPairRule_finishPrimaryWithSecondary = 0x00000001;
        public static final int SplitPairRule_finishSecondaryWithPrimary = 0x00000002;
        public static final int SplitPairRule_splitLayoutDirection = 0x00000003;
        public static final int SplitPairRule_splitMinSmallestWidth = 0x00000004;
        public static final int SplitPairRule_splitMinWidth = 0x00000005;
        public static final int SplitPairRule_splitRatio = 0x00000006;
        public static final int[] SplitPlaceholderRule = null;
        public static final int SplitPlaceholderRule_placeholderActivityName = 0x00000000;
        public static final int SplitPlaceholderRule_splitLayoutDirection = 0x00000001;
        public static final int SplitPlaceholderRule_splitMinSmallestWidth = 0x00000002;
        public static final int SplitPlaceholderRule_splitMinWidth = 0x00000003;
        public static final int SplitPlaceholderRule_splitRatio = 0x00000004;

        static {
            ActivityFilter = new int[]{com.android.contacts.R.attr.activityAction, com.android.contacts.R.attr.activityName};
            ActivityRule = new int[]{com.android.contacts.R.attr.alwaysExpand};
            SplitPairFilter = new int[]{com.android.contacts.R.attr.primaryActivityName, com.android.contacts.R.attr.secondaryActivityAction, com.android.contacts.R.attr.secondaryActivityName};
            SplitPairRule = new int[]{com.android.contacts.R.attr.clearTop, com.android.contacts.R.attr.finishPrimaryWithSecondary, com.android.contacts.R.attr.finishSecondaryWithPrimary, com.android.contacts.R.attr.splitLayoutDirection, com.android.contacts.R.attr.splitMinSmallestWidth, com.android.contacts.R.attr.splitMinWidth, com.android.contacts.R.attr.splitRatio};
            SplitPlaceholderRule = new int[]{com.android.contacts.R.attr.placeholderActivityName, com.android.contacts.R.attr.splitLayoutDirection, com.android.contacts.R.attr.splitMinSmallestWidth, com.android.contacts.R.attr.splitMinWidth, com.android.contacts.R.attr.splitRatio};
        }

        private styleable() {
        }
    }

    private R() {
    }
}
