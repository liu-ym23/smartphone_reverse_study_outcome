package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api22Impl {
        private Api22Impl() {
        }

        public static Person fromPersistableBundle(PersistableBundle r100) {
            return new Builder().setName(r100.getString("name")).setUri(r100.getString("uri")).setKey(r100.getString("key")).setBot(r100.getBoolean(Person.IS_BOT_KEY)).setImportant(r100.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        public static PersistableBundle toPersistableBundle(Person r100) {
            PersistableBundle r101 = new PersistableBundle();
            CharSequence r102 = r100.mName;
            if (r102 == null) goto L5;
            String r103 = r102.toString();
        L6:
            r101.putString("name", r103);
            r101.putString("uri", r100.mUri);
            r101.putString("key", r100.mKey);
            r101.putBoolean(Person.IS_BOT_KEY, r100.mIsBot);
            r101.putBoolean(Person.IS_IMPORTANT_KEY, r100.mIsImportant);
            return r101;
        L5:
            r103 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Person fromAndroidPerson(android.app.Person r100) {
            Builder r101 = new Builder().setName(r100.getName());
            if (r100.getIcon() == null) goto L5;
            IconCompat r102 = IconCompat.createFromIcon(r100.getIcon());
        L7:
            return r101.setIcon(r102).setUri(r100.getUri()).setKey(r100.getKey()).setBot(r100.isBot()).setImportant(r100.isImportant()).build();
        L5:
            r102 = null;
            goto L7
        }

        public static android.app.Person toAndroidPerson(Person r100) {
            android.app.Person.Builder r101 = new android.app.Person.Builder().setName(r100.getName());
            if (r100.getIcon() == null) goto L5;
            Icon r102 = r100.getIcon().toIcon();
        L7:
            return r101.setIcon(r102).setUri(r100.getUri()).setKey(r100.getKey()).setBot(r100.isBot()).setImportant(r100.isImportant()).build();
        L5:
            r102 = null;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Builder {
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        String mKey;
        CharSequence mName;
        String mUri;

        public Builder() {
        }

        public Person build() {
            return new Person(this);
        }

        public Builder(Person r100) {
            this.mName = r100.mName;
            this.mIcon = r100.mIcon;
            this.mUri = r100.mUri;
            this.mKey = r100.mKey;
            this.mIsBot = r100.mIsBot;
            this.mIsImportant = r100.mIsImportant;
        }

        public Builder setBot(boolean r100) {
            this.mIsBot = r100;
            return this;
        }

        public Builder setIcon(IconCompat r100) {
            this.mIcon = r100;
            return this;
        }

        public Builder setImportant(boolean r100) {
            this.mIsImportant = r100;
            return this;
        }

        public Builder setKey(String r100) {
            this.mKey = r100;
            return this;
        }

        public Builder setName(CharSequence r100) {
            this.mName = r100;
            return this;
        }

        public Builder setUri(String r100) {
            this.mUri = r100;
            return this;
        }
    }

    public String resolveToLegacyUri() {
        String r100 = this.mUri;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.mName != null) goto L8;
        return "";
    L8:
        return "name:" + this.mName;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putCharSequence("name", this.mName);
        IconCompat r101 = this.mIcon;
        if (r101 == null) goto L5;
        Bundle r102 = r101.toBundle();
    L6:
        r100.putBundle("icon", r102);
        r100.putString("uri", this.mUri);
        r100.putString("key", this.mKey);
        r100.putBoolean(IS_BOT_KEY, this.mIsBot);
        r100.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public int hashCode() {
        String r100 = getKey();
        if (r100 == null) goto L7;
        return r100.hashCode();
    L7:
        return Objects.hash(new Object[]{getName(), getUri(), Boolean.valueOf(isBot()), Boolean.valueOf(isImportant())});
    }

    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public Person(Builder r100) {
        this.mName = r100.mName;
        this.mIcon = r100.mIcon;
        this.mUri = r100.mUri;
        this.mKey = r100.mKey;
        this.mIsBot = r100.mIsBot;
        this.mIsImportant = r100.mIsImportant;
    }

    public static Person fromAndroidPerson(android.app.Person r100) {
        return Api28Impl.fromAndroidPerson(r100);
    }

    public static Person fromBundle(Bundle r100) {
        Bundle r101 = r100.getBundle("icon");
        Builder r102 = new Builder().setName(r100.getCharSequence("name"));
        if (r101 == null) goto L5;
        IconCompat r103 = IconCompat.createFromBundle(r101);
    L7:
        return r102.setIcon(r103).setUri(r100.getString("uri")).setKey(r100.getString("key")).setBot(r100.getBoolean(IS_BOT_KEY)).setImportant(r100.getBoolean(IS_IMPORTANT_KEY)).build();
    L5:
        r103 = null;
        goto L7
    }

    public static Person fromPersistableBundle(PersistableBundle r100) {
        return Api22Impl.fromPersistableBundle(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Person) == true) goto L8;
        return false;
    L8:
        Person r101 = (Person) r100;
        String r102 = getKey();
        String r103 = r101.getKey();
        if (r102 != null) goto L23;
        if (r103 != null) goto L23;
        if (Objects.equals(Objects.toString(getName()), Objects.toString(r101.getName())) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(getUri(), r101.getUri()) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(Boolean.valueOf(isBot()), Boolean.valueOf(r101.isBot())) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(Boolean.valueOf(isImportant()), Boolean.valueOf(r101.isImportant())) == false) goto L27;
        return true;
    L27:
        return false;
    L23:
        return Objects.equals(r102, r103);
    }
}
