package com.stepos.pps.data.ouc;

import android.content.Context;
import android.os.DropBoxManager;
import com.stepos.pps.data.ouc.parsers.ems.EmsDefaultParser;
import com.stepos.pps.data.ouc.parsers.ems.EmsSwtParser;
import com.stepos.pps.data.util.LogUtil;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes.dex */
public class DropBoxParserManager {
    private static final String TAG = "PPS:DropBoxParserManager";

    private static final class DropBoxFileParserBuilder {
        static DropBoxParserManager sDropBoxParserManager = new DropBoxParserManager();

        private DropBoxFileParserBuilder() {
        }
    }

    public static DropBoxParserManager getInstance() {
        return DropBoxFileParserBuilder.sDropBoxParserManager;
    }

    private DropBoxParserManager() {
    }

    public ErrorInfo parse(DropBoxManager.Entry entry, Context context) {
        IDropBoxEntryParser parser = getParser(entry.getTag().toLowerCase());
        if (parser != null) {
            try {
                return ErrorInfo.from(parser.parse(entry), context);
            } catch (IOException e) {
                LogUtil.e(TAG, "parse dropBox entry io exception:" + e.toString());
                return null;
            } catch (JSONException e2) {
                LogUtil.e(TAG, "parse dropBox entry json exception:" + e2.toString());
                return null;
            }
        }
        LogUtil.w(TAG, "parser is null!!! tag = " + entry.getTag());
        return null;
    }

    private IDropBoxEntryParser getParser(String str) {
        if (!str.startsWith(ErrorInfo.ERROR_TYPE_EMS)) {
            return null;
        }
        if (str.contains("swt")) {
            return new EmsSwtParser();
        }
        return new EmsDefaultParser();
    }
}
