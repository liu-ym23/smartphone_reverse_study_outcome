package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public class LanguageTaggedString extends Array {
    public LanguageTaggedString(String language, String string) {
        this(new UnicodeString(language), new UnicodeString(string));
    }

    public LanguageTaggedString(UnicodeString language, UnicodeString string) {
        setTag(38);
        language.getClass();
        add(language);
        string.getClass();
        add(string);
    }

    public UnicodeString getLanguage() {
        return (UnicodeString) getDataItems().get(0);
    }

    public UnicodeString getString() {
        return (UnicodeString) getDataItems().get(1);
    }
}
