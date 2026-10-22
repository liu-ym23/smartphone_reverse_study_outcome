package androidx.core.os;

import androidx.annotation.IntRange;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Locale;

/* loaded from: classes2.dex */
interface LocaleListInterface {
    Locale get(int i);

    Locale getFirstMatch(String[] strArr);

    Object getLocaleList();

    @IntRange(from = -1)
    int indexOf(Locale locale);

    boolean isEmpty();

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    int size();

    String toLanguageTags();
}
