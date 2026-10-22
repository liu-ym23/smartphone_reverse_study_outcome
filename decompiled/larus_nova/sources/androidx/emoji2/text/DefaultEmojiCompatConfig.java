package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class DefaultEmojiCompatConfig {

    public static class DefaultEmojiCompatConfigFactory {
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            if (Build.VERSION.SDK_INT < 28) goto L7;
            return new DefaultEmojiCompatConfigHelper_API28();
        L7:
            return new DefaultEmojiCompatConfigHelper_API19();
        }

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper r100) {
            if (r100 != null) goto L6;
            r100 = getHelperForApi();
        L6:
            this.mHelper = r100;
        }

        private List<List<byte[]>> convertToByteArray(Signature[] r100) {
            ArrayList r101 = new ArrayList();
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            r101.add(r100[r103].toByteArray());
            r103 = r103 + 1;
            goto L3
        L6:
            return Collections.singletonList(r101);
        }

        private boolean hasFlagSystem(ProviderInfo r100) {
            if (r100 == null) goto L8;
            ApplicationInfo r101 = r100.applicationInfo;
            if (r101 == null) goto L8;
            if ((r101.flags & 1) != 1) goto L8;
            return true;
        L8:
            return false;
        }

        private ProviderInfo queryDefaultInstalledContentProvider(PackageManager r100) {
            Iterator<ResolveInfo> r101 = this.mHelper.queryIntentContentProviders(r100, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            ResolveInfo r102 = r101.next();
            ProviderInfo r103 = this.mHelper.getProviderInfo(r102);
            if (hasFlagSystem(r103) == false) goto L4;
            return r103;
        L8:
            return null;
        }

        public EmojiCompat.Config create(Context r100) {
            return configOrNull(r100, queryForDefaultFontRequest(r100));
        }

        public FontRequest queryForDefaultFontRequest(Context r100) {
            PackageManager r101 = r100.getPackageManager();
            Preconditions.checkNotNull(r101, "Package manager required to locate emoji font provider");
            ProviderInfo r102 = queryDefaultInstalledContentProvider(r101);
            if (r102 != null) goto L8;
            return null;
        L8:
            return generateFontRequestFrom(r102, r101);
        L7:
            return null;
        }

        private EmojiCompat.Config configOrNull(Context r100, FontRequest r101) {
            if (r101 != null) goto L6;
            return null;
        L6:
            return new FontRequestEmojiCompatConfig(r100, r101);
        }

        private FontRequest generateFontRequestFrom(ProviderInfo r100, PackageManager r101) throws PackageManager.NameNotFoundException {
            String r102 = r100.authority;
            String r103 = r100.packageName;
            return new FontRequest(r102, r103, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r101, r103)));
        }
    }

    public static class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
        }

        public ProviderInfo getProviderInfo(ResolveInfo r100) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] getSigningSignatures(PackageManager r100, String r101) throws PackageManager.NameNotFoundException {
            return r100.getPackageInfo(r101, 64).signatures;
        }

        public List<ResolveInfo> queryIntentContentProviders(PackageManager r100, Intent r101, int r102) {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper_API19() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public ProviderInfo getProviderInfo(ResolveInfo r100) {
            return r100.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public List<ResolveInfo> queryIntentContentProviders(PackageManager r100, Intent r101, int r102) {
            return r100.queryIntentContentProviders(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public Signature[] getSigningSignatures(PackageManager r100, String r101) throws PackageManager.NameNotFoundException {
            return r100.getPackageInfo(r101, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig create(Context r100) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(r100);
    }
}
