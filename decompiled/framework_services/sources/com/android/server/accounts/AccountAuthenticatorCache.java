package com.android.server.accounts;

import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.internal.R;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class AccountAuthenticatorCache extends RegisteredServicesCache<AuthenticatorDescription> implements IAccountAuthenticatorCache {
    private static final String TAG = "Account";
    private static final MySerializer sSerializer = null;

    private static class MySerializer implements XmlSerializerAndParser<AuthenticatorDescription> {
        /* synthetic */ MySerializer(AccountAuthenticatorCacheIA r1) {
            this();
        }

        private MySerializer() {
        }

        /* JADX INFO: renamed from: createFromXml, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m879createFromXml(TypedXmlPullParser r1) throws IOException, XmlPullParserException {
            return createFromXml(r1);
        }

        public /* bridge */ /* synthetic */ void writeAsXml(Object r1, TypedXmlSerializer r2) throws IOException {
            writeAsXml((AuthenticatorDescription) r1, r2);
        }

        public void writeAsXml(AuthenticatorDescription item, TypedXmlSerializer out) throws IOException {
            out.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, item.type);
        }

        public AuthenticatorDescription createFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            return AuthenticatorDescription.newKey(parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE));
        }
    }

    @Override // com.android.server.accounts.IAccountAuthenticatorCache
    public /* bridge */ /* synthetic */ RegisteredServicesCache.ServiceInfo getServiceInfo(AuthenticatorDescription r1, int r2) {
        return super.getServiceInfo(r1, r2);
    }

    /* JADX INFO: renamed from: parseServiceAttributes, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m878parseServiceAttributes(Resources r1, String r2, AttributeSet r3) {
        return parseServiceAttributes(r1, r2, r3);
    }

    static {
        sSerializer = new MySerializer(null);
    }

    public AccountAuthenticatorCache(Context context) {
        super(context, "android.accounts.AccountAuthenticator", "android.accounts.AccountAuthenticator", "account-authenticator", sSerializer);
    }

    public AuthenticatorDescription parseServiceAttributes(Resources res, String packageName, AttributeSet attrs) {
        TypedArray sa = res.obtainAttributes(attrs, R.styleable.AccountAuthenticator);
        String accountType = sa.getString(2);     // Catch: Throwable -> L14
        int labelId = sa.getResourceId(0, 0);     // Catch: Throwable -> L14
        int iconId = sa.getResourceId(1, 0);     // Catch: Throwable -> L14
        int smallIconId = sa.getResourceId(3, 0);     // Catch: Throwable -> L14
        int prefId = sa.getResourceId(4, 0);     // Catch: Throwable -> L14
        boolean customTokens = sa.getBoolean(5, false);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(accountType) == false) goto L7;
        sa.recycle();
        return null;
    L7:
        AuthenticatorDescription r2 = new AuthenticatorDescription(accountType, packageName, labelId, iconId, smallIconId, prefId, customTokens);     // Catch: Throwable -> L12
        sa.recycle();
        return r2;
    L12:
        th = move-exception;
        Throwable r12 = th;
    L16:
        sa.recycle();
        throw r12;
    L14:
        th = move-exception;
        r12 = th;
        goto L16
    }
}
