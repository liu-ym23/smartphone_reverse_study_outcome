package com.stepos.alphame.utils;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import java.net.URI;

/* loaded from: classes.dex */
public final class NetEnvHelper {
    private static final String DOMAIN_DEV = "zyqldev.com";
    private static final String DOMAIN_PROD = "stepos.com";
    private static final String DOMAIN_STG = "zyqlstg.com";
    private static final String DOMAIN_TEST = "t-stepos.com";
    private static final String ENV_DEV = "dev";
    private static final String ENV_PROD = "prod";
    private static final String ENV_STG = "stg";
    private static final String ENV_TEST = "test";
    private static final String NET_ENV_KEY = "net_env";

    private NetEnvHelper() {
    }

    public static String getCurrentEnv() {
        String string;
        try {
            string = Settings.Secure.getString(ApplicationImpl.getApplication().getContentResolver(), NET_ENV_KEY);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string)) {
            return ENV_PROD;
        }
        String lowerCase = string.toLowerCase();
        if (!ENV_STG.equals(lowerCase) && !ENV_TEST.equals(lowerCase) && !ENV_DEV.equals(lowerCase)) {
            if (!ENV_PROD.equals(lowerCase)) {
                return ENV_PROD;
            }
        }
        return lowerCase;
    }

    private static String getDomainByEnv(String str) {
        return ENV_STG.equals(str) ? DOMAIN_STG : ENV_TEST.equals(str) ? DOMAIN_TEST : ENV_DEV.equals(str) ? DOMAIN_DEV : DOMAIN_PROD;
    }

    public static String mapUrl(String str) {
        Log.d("NetEnvHelper", "url = " + str);
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String domainByEnv = getDomainByEnv(getCurrentEnv());
        if (DOMAIN_PROD.equals(domainByEnv)) {
            return str;
        }
        try {
            URI uriCreate = URI.create(str);
            String host = uriCreate.getHost();
            if (!TextUtils.isEmpty(host) && host.endsWith(DOMAIN_PROD)) {
                return new URI(uriCreate.getScheme(), uriCreate.getUserInfo(), host.substring(0, host.length() - 10) + domainByEnv, uriCreate.getPort(), uriCreate.getPath(), uriCreate.getQuery(), uriCreate.getFragment()).toString();
            }
            return str;
        } catch (Exception unused) {
            return str.replace(DOMAIN_PROD, domainByEnv);
        }
    }
}
