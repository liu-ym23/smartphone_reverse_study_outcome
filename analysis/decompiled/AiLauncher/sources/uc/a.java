package uc;

import java.lang.Character;
import rc.InterfaceC5272b;

/* loaded from: classes5.dex */
public class a implements InterfaceC5272b {
    @Override // rc.InterfaceC5272b
    public Object a() {
        return this;
    }

    @Override // rc.InterfaceC5272b
    public String b() {
        return "fonts/language_greek.xml";
    }

    @Override // rc.InterfaceC5272b
    public Character.UnicodeBlock[] c() {
        return new Character.UnicodeBlock[]{Character.UnicodeBlock.GREEK, Character.UnicodeBlock.GREEK_EXTENDED};
    }
}
