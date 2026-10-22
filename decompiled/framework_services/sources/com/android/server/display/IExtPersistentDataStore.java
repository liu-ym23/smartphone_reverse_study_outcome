package com.android.server.display;

import android.graphics.Point;
import android.pico.utils.IExtBase;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPersistentDataStore extends IExtBase {
    Point getUserSwitchDefaultDisplayResolution();

    void loadFromXml(TypedXmlPullParser r1) throws IOException, XmlPullParserException;

    void saveToXml(TypedXmlSerializer r1) throws IOException;

    boolean setUserSwitchDefaultDisplayResolution(int r1, int r2);
}
